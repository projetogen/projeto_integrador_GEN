package com.projetoIntegrador.EducacaoDeQualidade.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoIntegrador.EducacaoDeQualidade.model.TemaModel;


public interface TemaRepository extends JpaRepository<TemaModel, Long> {
	public List<TemaModel> findAllByAssunto(String assunto);
}


