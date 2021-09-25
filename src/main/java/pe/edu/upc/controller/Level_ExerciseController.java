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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pe.edu.upc.entity.LevelExercise;
import pe.edu.upc.service.ILevel_ExerciseService;


@Controller
@RequestMapping("/levels_exercise")

public class Level_ExerciseController {

	@Autowired
	private ILevel_ExerciseService leService;
	
	@GetMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("levelExercise", new LevelExercise());
		return "/level_exercise/RegistroNiveles";
	}
	
	@PostMapping("/save")
	public String saveCategory(@Valid LevelExercise level_exercise, BindingResult result, Model model, SessionStatus status)
	throws Exception {
		
		if (result.hasErrors()) {
			return "/level_exercise/level_exercise";
		}
		else {
			int rpta = leService.insert(level_exercise);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe el nivel de ejercicio");
				return "/level_exercise/level_exercise";
			}
			else {
				model.addAttribute("mensaje", "Se guardo correctamente el nivel de ejercicio");
				status.setComplete();
			}
		}
		
		model.addAttribute("listLevel_Exercise", leService.list());
		
		return "redirect:/levels_exercise/list";
	}
	
	@GetMapping("/list")
	public String listLevel_Exercise(Model model) {
		try {
			model.addAttribute("levelExercise", new LevelExercise());
			model.addAttribute("listLevel_Exercise", leService.list());
		}
		catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/level_exercise/Niveles";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(Map<String, Object> model, @PathVariable(value="id") Integer id) {
		try {
			if (id!= null && id > 0) {
				leService.delete(id);
				model.put("mensaje", "Se elimino el nivel de ejercicio correctamente");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se pudo eliminar el nivel de ejercicio");
		}
		model.put("listLevel_Exercise", leService.list());
		return "/level_exercise/Niveles";
	}
	
	
	
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
	throws ParseException
	{
		Optional<LevelExercise> objLevel = leService.listarId(id);
		
		if (objLevel == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un rochesin");
			return "redirect:/levels_exercise/list";
		}
		else {
			model.addAttribute("levelExercise", objLevel);
			return "/level_exercise/RegistroNiveles";
		}
	}
	
	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute LevelExercise level) 
	throws ParseException
	{
		leService.listarId(level.getIdLevel_Exercises());
		return "Niveles";
	}
	
	
	
}
