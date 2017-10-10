package br.com.fabricadeprogramador.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.model.Funcionario;
import br.com.fabricadeprogramador.ws.service.FuncionarioService;

@RestController
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/funcionario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario) {

		Funcionario funcionarioCadastrado = funcionarioService.cadastrar(funcionario);
		return new ResponseEntity<>(funcionarioCadastrado, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Funcionario>> buscarTodosFuncionarios() {

		Collection<Funcionario> funcionariosBuscados = funcionarioService.buscarTodos();

		return new ResponseEntity<>(funcionariosBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/funcionario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Integer id){
		Funcionario funcionario = funcionarioService.buscarPorId(id);
		return new ResponseEntity<>(funcionario, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/funcionario/{id}")
	public ResponseEntity<Funcionario> excluirFuncionario(@PathVariable Integer id){
		Funcionario funcEncontrado = funcionarioService.buscarPorId(id);
		if( funcEncontrado==null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		funcionarioService.excluir(funcEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/funcionario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> alterarFuncionario(@RequestBody Funcionario funcionario){
		Funcionario funcAlterado = funcionarioService.alterar(funcionario);
		return new ResponseEntity<>(funcAlterado, HttpStatus.OK); 
	}
	
}
