package com.ProjetoSaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoSaude.entities.Aluno;
import com.ProjetoSaude.repository.AlunoRepository;

@Service
public class AlunoService {

	private final AlunoRepository alunoRepository;

	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public List<Aluno> getAllaluno() {
		return alunoRepository.findAll();
	}

	public Aluno getalunoById(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElse(null);
	}

	public Aluno salvaraluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno updatealuno(Long id, Aluno updatedaluno) {
		Optional<Aluno> existingaluno = alunoRepository.findById(id);
		if (existingaluno.isPresent()) {
			updatedaluno.setId(id);
			return alunoRepository.save(updatedaluno);
		}
		return null;
	}

	public boolean deletealuno(Long id) {
		Optional<Aluno> existingaluno = alunoRepository.findById(id);
		if (existingaluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
