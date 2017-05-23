package com.posweb.unipe.frameworks.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.posweb.unipe.frameworks.model.UsuarioModel;
import com.posweb.unipe.frameworks.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	
	@RequestMapping(value="/registro", method = RequestMethod.GET)
	public ModelAndView registro(){
		ModelAndView mv = new ModelAndView();
		UsuarioModel usuario = new UsuarioModel();
		mv.addObject("usuario", usuario);
		mv.setViewName("registro");
		return mv;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid UsuarioModel usuario, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		UsuarioModel usuarioExiste = usuarioService.findUserByEmail(usuario.getEmail());
		if (usuarioExiste != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"Já existe um usuário registrado com esse email");
		}
		if (bindingResult.hasErrors()) {
			mv.setViewName("registro");
		} else {
			usuarioService.saveUser(usuario);
			mv.addObject("successo", "Usuário registrado com Sucesso");
			mv.addObject("usuario", new UsuarioModel());
			mv.setViewName("registro");
			
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView();
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		UsuarioModel usuario = usuarioService.findUserByEmail(aut.getName());
		mv.addObject("userName", "Bem Vindo " + usuario.getNome() + " " + usuario.getsobreNome() + " (" + usuario.getEmail() + ")");
		mv.addObject("admin","Conteúdo disponível apenas para Administradores");
		mv.setViewName("admin/home");
		return mv;
	}
	

}
