package com.teste.projetosaude.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ProjetoSaude.entities.Aluno;

class AlunoTest {
	
	private Aluno aluno;

	@BeforeEach
	void setUp() {
		aluno = new Aluno(1L, "Beatriz", "beatriz@gmail.com", "12345");
	}

	@Test
	@DisplayName("Testando o id")
	void testId() {
		aluno.setId(2L);
		// Assert
		Assertions.assertEquals(2L, aluno.getId());
	}

	@Test
	@DisplayName("Testando o nome")
	void testNome() {
		aluno.setNome("Beatriz");
		// Assert
		Assertions.assertEquals("Beatriz", aluno.getNome());
	}

	@Test
	@DisplayName("Testando o email")
	void testEmail() {
		aluno.setEmail("beatriz@gmail.com");
		// Assert
		Assertions.assertEquals("beatriz@gmail.com", aluno.getEmail());
	}

	@Test
	@DisplayName("Testando a senha")
	void testSenha() {
		aluno.setSenha("12345");
		// Assert
		Assertions.assertEquals("12345", aluno.getSenha());
	}

	@Test
	@DisplayName("Testando o construtor")
	void testConstrutorAll() {
		Aluno novoAluno = new Aluno(1L, "Beatriz", "beatriz@gmail.com", "12345");
		Assertions.assertAll("novoAluno", 
				() -> Assertions.assertEquals(3L, novoAluno.getId()),
				() -> Assertions.assertEquals("Beatriz", novoAluno.getNome()),
				() -> Assertions.assertEquals("beatriz@gmail.com", novoAluno.getEmail()),
				() -> Assertions.assertEquals("12345", novoAluno.getSenha()));
	}
}
