package com.posweb.unipe.frameworks.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.posweb.unipe.frameworks.model.FuncaoModel;
import com.posweb.unipe.frameworks.model.UsuarioModel;
import com.posweb.unipe.frameworks.repository.FuncaoRepository;
import com.posweb.unipe.frameworks.repository.UserRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UserRepository usuarioRepository;
	@Autowired
    private FuncaoRepository funcaoRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UsuarioModel findUserByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public void saveUser(UsuarioModel usuario) {
		usuario.setsenha(bCryptPasswordEncoder.encode(usuario.getsenha()));
        usuario.setActive(1);
        FuncaoModel usuarioFuncao = funcaoRepository.findByFuncao("ADMIN");
        usuario.setfuncoes(new HashSet<FuncaoModel>(Arrays.asList(usuarioFuncao)));
		usuarioRepository.save(usuario);
	}

}
