package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	
	ClienteRepository clienteRepository;

	// Negocios
	private Cliente cadastrar(Cliente cliente) {	

		return clienteRepository.save(cliente);

	}

	private Collection<Cliente> buscarTodos() {
		return clientes.values();
	}
	
	public void excluir (Cliente cliente){
		clientes.remove(cliente.getId());
	}
	
	private Cliente buscarPorId(Integer id) {
		return clientes.get(id);
	}
	
	private Cliente alterar(Cliente cliente){
		 clientes.put(cliente.getId(), cliente);
		 return cliente;
	}
}
