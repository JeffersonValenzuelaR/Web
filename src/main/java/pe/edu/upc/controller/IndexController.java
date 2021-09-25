package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping
public class IndexController {
	@GetMapping("/")
	public String home() {
		return "Landing";
	}
	
	@GetMapping("/inicio")
	public String landing() {
	    return "Index";
	}


	@GetMapping("/iniciar")
	public String login() {
	    return "login";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
	    return "Contacto";
	}
	
	

	
	
}

