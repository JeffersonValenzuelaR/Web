package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Comments;
import pe.edu.upc.entity.DetailsForum;
import pe.edu.upc.entity.Forum;
import pe.edu.upc.entity.Users;
import pe.edu.upc.service.ICommentsService;
import pe.edu.upc.service.IDetailsForumService;
import pe.edu.upc.service.IForumService;
import pe.edu.upc.service.IUserService;
@Controller
@RequestMapping("/forums")


public class ForumController {

	@Autowired
	private IForumService foService;
	
	@Autowired
	private IDetailsForumService defoService;
	
	@Autowired
	private ICommentsService commenService;
	
	@Autowired
	private IUserService userService;
	
	private Forum f ;

	private Users cuenta;
	
	@GetMapping("/new")
	public String newForum(Model model) {
		model.addAttribute("forum", new Forum());
		return "/forum/RegistroForo";
	}
	
	@PostMapping("/save")
	public String saveCategory(@Valid Forum forum, BindingResult result, Model model, SessionStatus status)
	throws Exception {
		
		if (result.hasErrors()) {
			return "/forum/forum";
		}
		else {
			int rpta = foService.insert(forum);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe el foro");
				return "/forum/forum";
			}
			else {
				model.addAttribute("mensaje", "Se guardo correctamente el foro");
				status.setComplete();
			}
		}
		
		model.addAttribute("listForum", foService.list());
		
		return "redirect:/forums/list";
	}
	
	@GetMapping("/list")
	public String listForums(Model model) {
		try {
			model.addAttribute("forum", new Forum());
			model.addAttribute("listForum", foService.list());
		}
		catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/forum/Foros";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(Map<String, Object> model, @PathVariable(value="id") Integer id) {
		try {
			if (id!= null && id > 0) {
				foService.delete(id);
				model.put("mensaje", "Se elimino el foro correctamente");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se pudo eliminar el foro");
		}
		model.put("listForum", foService.list());
		return "redirect:/forums/list";
	}
	
	@RequestMapping("/ingresar/{column}/{id}")
	public String ingresar(Map<String, Object> model, @PathVariable(value="column") String column,@PathVariable(value="id") int id) {
		try {
			Optional<Forum> fo = foService.listarId(id);
			Optional<DetailsForum> forD = defoService.listarIdxIdForo(id);
			if (forD.isPresent()) {
					model.put("detailsForum",forD.get());
					model.put("listComments", commenService.list());
					
			}
			else {
				model.put("detailsForum",new DetailsForum());
				model.put("listComments", commenService.list());
				
			}
			model.put("comments", new Comments());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se pudo eliminar el foro");
		}
		String cadena="/forum/"+column;
		model.put("idforum", id);
		
		return cadena;
	}
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException
			{
				Optional<DetailsForum> objDetailsForum = defoService.listarId(id);
				
				if (objDetailsForum == null) {
					objRedir.addFlashAttribute("mensaje", "Ocurrio un rochesin");
					return "redirect:/detailsforum/list";
				}
				else {
					model.addAttribute("detailsforum", objDetailsForum);
					return "/detailsforum/ModificarForo";
				}
			}
	@GetMapping("/newdetails/{id}")
	public String newDetailsForum(Model model,@PathVariable(value="id") int id) {
		Optional<DetailsForum> forD = defoService.listarIdxIdForo(id);
		if (forD.isPresent()) {
			model.addAttribute("detailsForum",forD.get());
			model.addAttribute("idforum", id);
		}
		else
		{	model.addAttribute("detailsForum", new DetailsForum());
			model.addAttribute("idforum", id);
			}
		
		return "/forum/ModificarForo";
	}
	
	@RequestMapping("/savedetails/{id}")
	public String saveDetails(@Valid DetailsForum detailsForum, BindingResult result, Model model, SessionStatus status, @PathVariable(value="id") int id)
	throws Exception {
		
		if (result.hasErrors()) {
			return "/forum/ModificarForo";
		}
		else {
			Optional<Forum> fo = foService.listarId(id);
			f= fo.get();
			detailsForum.setForum(f);
			int rpta = defoService.insert(detailsForum);
			if (rpta > 0) {
				
				return "/forum/ModificarForo";
			}
			else {
				status.setComplete();
				String cadena="redirect:/forums/ingresar/" + f.getTopic()+"/"+f.getIdForums();
				return cadena;
			}
		}
		
		
	}
	@RequestMapping("/savecomment/{id}")
	public String saveComment(@Valid Comments comments, BindingResult result, Model model, SessionStatus status, @PathVariable(value="id") int id)
	throws Exception {
		
		if (result.hasErrors()) {
			return "/forum/ModificarForo";
		}
		else {
			Authentication auth = SecurityContextHolder
		            .getContext()
		            .getAuthentication();
		    UserDetails  userDetail = (UserDetails) auth.getPrincipal(); // para obtener el usuario logueado
		    cuenta = this.userService.getAccount(userDetail.getUsername());
			Optional<DetailsForum> forD = defoService.listarIdxIdForo(id);
			comments.setDetailsForum(forD.get());
			comments.setUsers(cuenta);
			int rpta = commenService.insert(comments);
			if (rpta > 0) {
				return "/forum/ModificarForo";
			}
			else {
				status.setComplete();
				String cadena="redirect:/forums/ingresar/" + f.getTopic()+"/"+f.getIdForums();
				return cadena;
			}
		}
		
		
	}
}
