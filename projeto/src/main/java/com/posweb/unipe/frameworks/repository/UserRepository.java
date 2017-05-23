package com.posweb.unipe.frameworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posweb.unipe.frameworks.model.UsuarioModel;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UsuarioModel, Long> {
	 UsuarioModel findByEmail(String email);
}
