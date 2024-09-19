package com.ProjetoSaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoSaude.entities.Aluno;

public interface AlunoRepository  extends JpaRepository <Aluno,Long> {

}
