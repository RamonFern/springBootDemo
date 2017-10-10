package br.com.fabricadeprogramador.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.ws.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
