package br.com.secretariaeducacao.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretariaeducacao.model.Aluno;


@RestController
public class AlunoController {
	
	Map<Integer, Aluno> alunos= new HashMap<>();
	Integer proximoId = 1;

	// Negocios
	private Aluno cadastrar(Aluno aluno) {
		aluno.setId(proximoId);
		proximoId++;
		alunos.put(aluno.getId(), aluno);
		return aluno;

	}

	private Collection<Aluno> buscarTodos() {
		return alunos.values();
	}
	
	public void excluir (Aluno aluno){
		alunos.remove(aluno.getId());
	}
	
	private Aluno buscarPorId(Integer id) {
		return alunos.get(id);
	}
	
	private Aluno alterar(Aluno aluno){
		 alunos.put(aluno.getId(), aluno);
		 return aluno;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/alunos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {

		Aluno alunoCadastrado = cadastrar(aluno);
		return new ResponseEntity<>(alunoCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Aluno>> buscarTodosAlunos() {

		Collection<Aluno> alunosBuscados = buscarTodos();

		return new ResponseEntity<>(alunosBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/alunos/{id}" )
	public ResponseEntity<Aluno> excluirAluno(@PathVariable Integer id) {
		
		Aluno alunoEncontrado = buscarPorId(id);
		if (alunoEncontrado==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		excluir(alunoEncontrado);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/alunos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> alterarAluno(@RequestBody Aluno aluno) {

		Aluno alunoAlterado = alterar(aluno);
		return new ResponseEntity<>(alunoAlterado, HttpStatus.OK);
	}
}
