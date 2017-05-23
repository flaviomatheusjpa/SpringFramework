package com.posweb.unipe.frameworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.posweb.unipe.frameworks.model.ContatoModel;
import com.posweb.unipe.frameworks.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
    private ContatoRepository repository;
     
    public List<ContatoModel> findAll() {
        return repository.findAll();
    }
     
    public ContatoModel findOne(Long id) {
        return repository.findOne(id);
    }
     
    public ContatoModel save(ContatoModel contato) {
        return repository.saveAndFlush(contato);
    }
     
    public void delete(Long id) {
        repository.delete(id);
    }
	
	
}
