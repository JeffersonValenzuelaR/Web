package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.TypeExercise;
import pe.edu.upc.service.IType_ExerciseService;

@Controller
@RequestMapping("/types_exercise")

public class Type_ExerciseController {

	@Autowired
	private IType_ExerciseService teService;

	
	@GetMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("typeExercise", new TypeExercise());
		return "/type_exercise/RegistroCompetencias";
	}
	
	@PostMapping("/save")
	public String saveCategory(@Valid TypeExercise type_exercise, BindingResult result, Model model, SessionStatus status)
	throws Exception {
		
		if (result.hasErrors()) {
			return "/type_exercise/type_exercise";
		}
		else {
			int rpta = teService.insert(type_exercise);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe el tipo de ejercicio");
				return "/type_exercise/type_exercise";
			}
			else {
				model.addAttribute("mensaje", "Se guardo correctamente el tipo de ejercicio");
				status.setComplete();
			}
		}
		
		model.addAttribute("listType_Exercise", teService.list());
		
		return "redirect:/types_exercise/list";
	}
	
	@GetMapping("/list")
	public String listType_Exercise(Model model) {
		try {
			model.addAttribute("typeExercise", new TypeExercise());
			model.addAttribute("listType_Exercise", teService.list());
		}
		catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/type_exercise/Competencias";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(Map<String, Object> model, @PathVariable(value="id") Integer id) {
		try {
			if (id!= null && id > 0) {
				teService.delete(id);
				model.put("mensaje", "Se elimino el tipo de ejercicio correctamente");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se pudo eliminar el tipo de ejercicio");
		}
		model.put("listType_Exercise", teService.list());
		return "/type_exercise/Competencias";
	}
	
}
