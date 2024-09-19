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

import com.ProjetoSaude.entities.Agendamentos;
import com.ProjetoSaude.service.AgendamentosService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/agendamento")
public class AgendamentosController {

	private final AgendamentosService agendamentosService;
	@Autowired
	public AgendamentosController(AgendamentosService agendamentosService) {
		this.agendamentosService = agendamentosService;
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Localiza agendamentos por ID")
	public ResponseEntity<Agendamentos> getAgendamentosById(@PathVariable Long id) {
		Agendamentos agendamentos = agendamentosService.getagendamentosById(id);
		if (agendamentos != null) {
			return ResponseEntity.ok(agendamentos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Aprensenta todas as agendamentoss")
	public ResponseEntity<List<Agendamentos>> getAllAgendamentos() {
		List<Agendamentos> agendamentos = agendamentosService.getAllagendamentos();
		return ResponseEntity.ok(agendamentos);
	}

	@PostMapping
	@Operation(summary = "Cadastra uma agendamentos")
	public ResponseEntity<Agendamentos> criarAgendamentos(@RequestBody Agendamentos agendamentos) {
		Agendamentos criarAgendamentos = agendamentosService.salvaragendamentos(agendamentos);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarAgendamentos);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera a agendamentos")
	public ResponseEntity<Agendamentos> updateAgendamentos(@PathVariable Long id,@RequestBody Agendamentos agendamentos) {
		Agendamentos updatedAgendamentos = agendamentosService.updateagendamentos(id, agendamentos);
		if (updatedAgendamentos != null) {
			return ResponseEntity.ok(updatedAgendamentos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma agendamentos")
	public ResponseEntity<String> deleteAgendamentos(@PathVariable Long id) {
		boolean deleted = agendamentosService.deleteagendamentos(id);
		if (deleted) {
			return ResponseEntity.ok().body("A agendamentos foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
