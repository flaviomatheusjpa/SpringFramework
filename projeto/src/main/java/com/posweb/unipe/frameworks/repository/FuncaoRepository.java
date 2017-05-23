package com.posweb.unipe.frameworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posweb.unipe.frameworks.model.FuncaoModel;

@Repository("funcaoRepository")
public interface FuncaoRepository extends JpaRepository<FuncaoModel, Integer>{
	FuncaoModel findByFuncao(String funcao);

}
