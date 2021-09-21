package com.caixaEletronico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caixaEletronico.model.Usuario;


@Repository
public interface Usuario_Repository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findByNomeCompletoContainingIgnoreCase(String nomeCompleto);
	public List<Usuario> findAllByAgencia(String agencia);
	public List<Usuario> findByConta(String conta);
}
