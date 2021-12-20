package com.projetoIntegrador.EducacaoDeQualidade.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoIntegrador.EducacaoDeQualidade.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long> {
	public List<TemaModel> findAllByAssunto(String assunto);
}


