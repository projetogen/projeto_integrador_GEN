package com.projetoIntegrador.EducacaoDeQualidade.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoIntegrador.EducacaoDeQualidade.model.TemaModel;
import com.projetoIntegrador.EducacaoDeQualidade.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	public List<TemaModel> findAllByNome_completo(String nome_completo);

}
