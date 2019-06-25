package com.bolsadeideas.springboot.app.controllers;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.dao.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@Controller
@RequestMapping("/cliente")
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public String showList(Model model) {
				
		model.addAttribute("titulo", "Lista de cliente");
		model.addAttribute("clientes", clienteService.searchForAll());
		return "lista";
	}
	
	@GetMapping("/form")
	public String guardar(Model model) {
		
		Cliente cliente = new Cliente();
		
		model.addAttribute("titulo", "Registrando cliente");
		model.addAttribute("cliente", cliente);
		
		return "form";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(name="id") Long id, Model model) {
		
		Cliente cliente = clienteService.findById(id);
		
		model.addAttribute("titulo", "Editando cliente");
		model.addAttribute("cliente", cliente);
		
		return "form";
		
	}
	
	@PostMapping("/form")
	public String saveCliente(@Valid @ModelAttribute("cliente") Cliente cliente, 
			BindingResult result ,SessionStatus status, Model model) {
		
		if(result.hasErrors()) {
			
			model.addAttribute("titulo", "Registrando cliente");
			return "/form";
		}
		
		clienteService.save(cliente);
		status.isComplete();
		
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(name="id") Long id, Model model) {
		
		if(id <= 0 || id == null)
			return "redirect:/cliente/listar";
		
		clienteService.deleteById(id);
		
		
		return "redirect:/cliente/listar";
		
	}

}
