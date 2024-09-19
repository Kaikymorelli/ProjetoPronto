	package com.ProjetoSaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoSaude.entities.Aluno;
import com.ProjetoSaude.service.AlunoService;

import io.swagger.v3.oas.annotations.Operation;





@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/aluno")
public class AlunoController {

	private final AlunoService alunoService;
	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Localiza aluno por ID")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
		Aluno aluno = alunoService.getalunoById(id);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Aprensenta todas as alunos")
	public ResponseEntity<List<Aluno>> getAllAluno() {
		List<Aluno> aluno = alunoService.getAllaluno();
		return ResponseEntity.ok(aluno);
	}

	@PostMapping 
	@Operation(summary = "Cadastra uma aluno")
	public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
		Aluno criarAluno = alunoService.salvaraluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarAluno);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera a aluno")
	public ResponseEntity<Aluno> updateAluno(@PathVariable Long id,@RequestBody Aluno aluno) {
		Aluno updatedAluno = alunoService.updatealuno(id, aluno);
		if (updatedAluno != null) {
			return ResponseEntity.ok(updatedAluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma aluno")
	public ResponseEntity<String> deleteAluno(@PathVariable Long id) {
		boolean deleted = alunoService.deletealuno(id);
		if (deleted) {
			return ResponseEntity.ok().body("A aluno foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
