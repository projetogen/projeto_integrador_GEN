package com.projetoIntegrador.EducacaoDeQualidade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoIntegrador.EducacaoDeQualidade.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	public List<UsuarioModel> findAllByNomecompleto(String nomecompleto);

	public Optional<UsuarioModel> findAllByUsuario(String usuario);

}
