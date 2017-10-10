package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.model.Funcionario;
import br.com.fabricadeprogramador.ws.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public Funcionario cadastrar(Funcionario funcionario) {
		
		return funcionarioRepository.save(funcionario);
	}
	
	public Collection<Funcionario> buscarTodos() {
		return funcionarioRepository.findAll();
	}
	
	public void excluir (Funcionario funcionario){
		funcionarioRepository.delete(funcionario);
	}
	
	public Funcionario buscarPorId(Integer id) {
		return funcionarioRepository.findOne(id);
	}
	
	public Funcionario alterar(Funcionario funcionario){
		return funcionarioRepository.save(funcionario);
	}
	
	
}
