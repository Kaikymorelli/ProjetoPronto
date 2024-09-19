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

import com.ProjetoSaude.entities.Psicologa;
import com.ProjetoSaude.service.PsicologaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/psicologa")
public class PsicologaController {

	private final PsicologaService psicologaService;
	@Autowired
	public PsicologaController(PsicologaService psicologaService) {
		this.psicologaService = psicologaService;
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Localiza psicologa por ID")
	public ResponseEntity<Psicologa> getPsicologaById(@PathVariable Long id) {
		Psicologa psicologa = psicologaService.getpsicologaById(id);
		if (psicologa != null) {
			return ResponseEntity.ok(psicologa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Aprensenta todas as psicologas")
	public ResponseEntity<List<Psicologa>> getAllPsicologa() {
		List<Psicologa> psicologa = psicologaService.getAllpsicologa();
		return ResponseEntity.ok(psicologa);
	}

	@PostMapping
	@Operation(summary = "Cadastra uma psicologa")
	public ResponseEntity<Psicologa> criarPsicologa(@RequestBody Psicologa psicologa) {
		Psicologa criarPsicologa = psicologaService.salvarpsicologa(psicologa);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarPsicologa);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera a psicologa")
	public ResponseEntity<Psicologa> updatePsicologa(@PathVariable Long id,@RequestBody Psicologa psicologa) {
		Psicologa updatedPsicologa = psicologaService.updatepsicologa(id, psicologa);
		if (updatedPsicologa != null) {
			return ResponseEntity.ok(updatedPsicologa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma psicologa")
	public ResponseEntity<String> deletePsicologa(@PathVariable Long id) {
		boolean deleted = psicologaService.deletepsicologa(id);
		if (deleted) {
			return ResponseEntity.ok().body("A psicologa foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
