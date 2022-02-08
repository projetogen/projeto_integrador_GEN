package com.projetoIntegrador.EducacaoDeQualidade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoIntegrador.EducacaoDeQualidade.model.PostagemModel;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

	public List<PostagemModel> findByTituloContainingIgnoreCase(String Titulo);
	public List<PostagemModel> findPostagemByTemaId(Long id);
}
