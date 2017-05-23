package com.posweb.unipe.frameworks.service;

import com.posweb.unipe.frameworks.model.UsuarioModel;

public interface UsuarioService {
	public UsuarioModel findUserByEmail(String email);
	public void saveUser(UsuarioModel user);
}
