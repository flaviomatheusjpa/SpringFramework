package com.posweb.unipe.frameworks.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.posweb.unipe.frameworks.model.ContatoModel;
import com.posweb.unipe.frameworks.service.ContatoService;

@Controller
public class ContatoController {
     
    @Autowired
    private ContatoService service;
     
    @GetMapping("/listacontatos")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/contato");
        mv.addObject("contatos", service.findAll());
         
        return mv;
    }
     
    @GetMapping("/add")
    public ModelAndView add(ContatoModel contato) {
         
        ModelAndView mv = new ModelAndView("/contatoAdd");
        mv.addObject("contato", contato);
         
        return mv;
    }
     
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
         
        return add(service.findOne(id));
    }
     
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
         
        service.delete(id);
         
        return findAll();
    }
 
    @PostMapping("/save")
    public ModelAndView save(@Valid ContatoModel contato, BindingResult result) {
         
        if(result.hasErrors()) {
            return add(contato);
        }
         
        service.save(contato);
         
        return findAll();
    }
     
}