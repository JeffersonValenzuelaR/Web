package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Exercise;
import pe.edu.upc.service.IExercise_Service;
import pe.edu.upc.service.ILevel_ExerciseService;
import pe.edu.upc.service.IType_ExerciseService;


@Controller
@RequestMapping("/exercises")
public class ExerciseController {
	
	@Autowired
	private IExercise_Service eService;
	@Autowired
	private ILevel_ExerciseService leService;
	@Autowired
	private IType_ExerciseService tyService;
	
		
	@GetMapping("/new")
	public String newExercise(Model model) {
		model.addAttribute("exercise", new Exercise());
		model.addAttribute("listLevel", leService.list());
		model.addAttribute("listType", tyService.list());
		return "exercise/RegistroEjercicios";
	}
	
	@PostMapping("/save")
	public String saveCategory(@Valid Exercise exercise, BindingResult result, Model model, SessionStatus status)
	throws Exception {
		
		if (result.hasErrors()) {
			return "/exercise/RegistroEjercicios";
		}
		else {
			int rpta = eService.insert(exercise);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe el ejercicio");
				return "/exercise/RegistroEjercicios";
			}
			else {
				model.addAttribute("mensaje", "Se guardo correctamente el ejercicio");
				status.setComplete();
			}
		}
		
		model.addAttribute("listExercise", eService.list());
		return "redirect:/exercises/list";
	}
	
	@GetMapping("/list")
	public String listEditoriales(Model model) {
		try {
			model.addAttribute("exercise", new Exercise());
			model.addAttribute("listExercise", eService.list());
		}
		catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/exercise/Ejercicios";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(Map<String, Object> model, @PathVariable(value="id") Integer id) {
		try {
			if (id!= null && id > 0) {
				eService.delete(id);
				model.put("mensaje", "Se elimino el ejercicio correctamente");
		}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se pudo eliminar el ejercicio");
		}
		model.put("listExercise", eService.list());
		return "/exercise/Ejercicios";
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
			throws ParseException{
		Optional<Exercise> objExer = eService.listarId(id);
		
		if (objExer == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un rochesin");
			return "redirect:/exercises/list";
		}
		else {
			model.addAttribute("exercise", objExer.get());
			model.addAttribute("listLevel", leService.list());
			model.addAttribute("listType", tyService.list());
			return "/exercise/RegistroEjercicios";
		}
	}
	
	@RequestMapping("/ingresar/{id}")
	public String ingresar(Map<String, Object> model, @PathVariable(value="id") String id) {
		try {
			String cadena="/exercise/"+id;
			return cadena;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		model.put("listExercise", eService.list());
		return "/exercise/Ejercicios";
	}
	
}
		
	
	
	
	
	
