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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Editorial;
import pe.edu.upc.service.IEditorialService;


@Controller
@RequestMapping("/editoriales")

public class EditorialController {
	
	@Autowired
	private IEditorialService edService;
	
	
	
	@GetMapping("/new")
	public String newEditorial(Model model) {
		model.addAttribute("editorial", new Editorial());
		return "/editorial/RegistroEditoriales";
	}
	
	@PostMapping("/save")
	public String saveCategory(@Valid Editorial editorial, BindingResult result, Model model, SessionStatus status)
	throws Exception {
		
		if (result.hasErrors()) {
			return "/editorial/editorial";
		}
		else {
			int rpta = edService.insert(editorial);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe la editorial");
				return "/editorial/editorial";
			}
			else {
				model.addAttribute("mensaje", "Se guardo correctamente la editorial");
				status.setComplete();
			}
		}
		
		model.addAttribute("listEditorial", edService.list());
		
		return "/editorial/Editoriales";
	}
	
	@GetMapping("/list")
	public String listEditoriales(Model model) {
		try {
			model.addAttribute("editorial", new Editorial());
			model.addAttribute("listEditorial", edService.list());
		}
		catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/editorial/Editoriales";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(Map<String, Object> model, @PathVariable(value="id") Integer id) {
		try {
			if (id!= null && id > 0) {
				edService.delete(id);
				model.put("mensaje", "Se elimino la editorial correctamente");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se pudo eliminar la editorial");
		}
		model.put("listEditoriales", edService.list());
		return "redirect:/editoriales/list";
	}	
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
	throws ParseException
	{
		Optional<Editorial> objEditorial = edService.listarId(id);
		
		if (objEditorial == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un rochesin");
			return "redirect:/editoriales/list";
		}
		else {
			model.addAttribute("editorial", objEditorial);
			return "/editorial/RegistroEditoriales";
		}
	}
	
	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Editorial editorial) 
	throws ParseException
	{
		edService.listarId(editorial.getIdEditorial());
		return "Editoriales";
	}
	
	
}
