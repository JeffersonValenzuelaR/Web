package pe.edu.upc.controller;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Talk;
import pe.edu.upc.service.ITalkService;


@Controller
@RequestMapping("/talks")

public class TalkController {

	@Autowired
	private ITalkService tlService;
	
	
	
	@GetMapping("/new")
	public String newtalk(Model model) {
		model.addAttribute("talk", new Talk());
		return "talk/RegistroCharlas";
	}
	
	@PostMapping("/save")
	public String saveCategory(@Valid Talk talk, BindingResult result, Model model, SessionStatus status)
	throws Exception {
		
		if (result.hasErrors()) {
			return "/talk/talk";
		}
		else {
			int rpta = tlService.insert(talk);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe la charla");
				return "/talk/talk";
			}
			else {
				model.addAttribute("mensaje", "Se guardo correctamente la charla");
				status.setComplete();
			}
		}
		
		model.addAttribute("listTalk", tlService.list());
		
		return "/talk/Charlas";
	}
	
	@GetMapping("/list")
	public String listTalk(Model model) {
		try {
			model.addAttribute("talk", new Talk());
			model.addAttribute("listTalk", tlService.list());
		}
		catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/talk/Charlas";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(Map<String, Object> model, @PathVariable(value="id") Integer id) {
		try {
			model.put("talk", new Talk());
			if (id!= null && id > 0) {
				tlService.delete(id);
				model.put("mensaje", "Se elimino la charla correctamente");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se pudo eliminar la charla ");
			model.put("listTalk", tlService.list());
			
		}
		
		return "redirect:/talks/list";
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException
			{
				Optional<Talk> objTalk = tlService.listarId(id);
				
				if (objTalk == null) {
					objRedir.addFlashAttribute("mensaje", "Ocurrio un rochesin");
					return "redirect:/talks/list";
				}
				else {
					model.addAttribute("talk", objTalk);
					return "/talk/RegistroCharlasMod";
				}
			}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Talk talk ) throws ParseException {
		List<Talk> listatalk;
		talk.setRoomName(talk.getRoomName());
		listatalk = tlService.BuscarNombre(talk.getRoomName());
		
		if (listatalk.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("listTalk", listatalk);				
		return "/talk/Charlas";
	}
	
	@PostMapping("/mod")
	public String saveMod(@Valid Talk talk, BindingResult result, Model model, SessionStatus status)
	throws Exception {
		
		if (result.hasErrors()) {
			return "/talk/talk";
		}
		else {
			boolean rpta = tlService.modificar(talk);
			if (rpta) {
				model.addAttribute("mensaje", "Se modificó correctamente");
				return "redirect:/talks/list";
			}
			else {
				model.addAttribute("mensaje", "Ocurrió un problema");
				status.setComplete();
			}
		}
		
		model.addAttribute("listTalk", tlService.list());
		
		return "redirect:/talks/list";
	}

}
