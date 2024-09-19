package com.ProjetoSaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoSaude.entities.Agendamentos;
import com.ProjetoSaude.repository.AgendamentosRepository;

@Service
public class AgendamentosService {

	private final AgendamentosRepository agendamentosRepository;

	@Autowired
	public AgendamentosService(AgendamentosRepository agendamentosRepository) {
		this.agendamentosRepository = agendamentosRepository;
	}
	
	public List<Agendamentos> getAllagendamentos() {
		return agendamentosRepository.findAll();
	}

	public Agendamentos getagendamentosById(Long id) {
		Optional<Agendamentos> agendamentos = agendamentosRepository.findById(id);
		return agendamentos.orElse(null);
	}

	public Agendamentos salvaragendamentos(Agendamentos agendamentos) {
		return agendamentosRepository.save(agendamentos);
	}

	public Agendamentos updateagendamentos(Long id, Agendamentos updatedagendamentos) {
		Optional<Agendamentos> existingagendamentos = agendamentosRepository.findById(id);
		if (existingagendamentos.isPresent()) {
			updatedagendamentos.setId(id);
			return agendamentosRepository.save(updatedagendamentos);
		}
		return null;
	}

	public boolean deleteagendamentos(Long id) {
		Optional<Agendamentos> existingagendamentos = agendamentosRepository.findById(id);
		if (existingagendamentos.isPresent()) {
			agendamentosRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
