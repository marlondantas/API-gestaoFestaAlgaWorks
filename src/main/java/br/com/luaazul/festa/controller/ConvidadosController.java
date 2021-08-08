package br.com.luaazul.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.luaazul.festa.model.Convidado;
import br.com.luaazul.festa.repository.ConvidadoRepository;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	ConvidadoRepository convidadoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		
		ModelAndView saida = new ModelAndView("ListaConvidados");
		
		saida.addObject("convidados",convidadoRepository.findAll());
		saida.addObject(new Convidado());
		
		return saida;
	}
	
	@PostMapping
	public String salvarConvidado(Convidado convidado) {
		
		this.convidadoRepository.save(convidado);
		
		return "redirect:/convidados";

	}
	
}
