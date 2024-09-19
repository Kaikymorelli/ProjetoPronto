package com.ProjetoSaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoSaude.entities.Psicologa;
import com.ProjetoSaude.repository.PsicologaRepository;

@Service
public class PsicologaService {

	private final PsicologaRepository psicologaRepository;

	@Autowired
	public PsicologaService(PsicologaRepository psicologaRepository) {
		this.psicologaRepository = psicologaRepository;
	}
	
	public List<Psicologa> getAllpsicologa() {
		return psicologaRepository.findAll();
	}

	public Psicologa getpsicologaById(Long id) {
		Optional<Psicologa> psicologa = psicologaRepository.findById(id);
		return psicologa.orElse(null);
	}

	public Psicologa salvarpsicologa(Psicologa psicologa) {
		return psicologaRepository.save(psicologa);
	}

	public Psicologa updatepsicologa(Long id, Psicologa updatedpsicologa) {
		Optional<Psicologa> existingpsicologa = psicologaRepository.findById(id);
		if (existingpsicologa.isPresent()) {
			updatedpsicologa.setId(id);
			return psicologaRepository.save(updatedpsicologa);
		}
		return null;
	}

	public boolean deletepsicologa(Long id) {
		Optional<Psicologa> existingpsicologa = psicologaRepository.findById(id);
		if (existingpsicologa.isPresent()) {
			psicologaRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
