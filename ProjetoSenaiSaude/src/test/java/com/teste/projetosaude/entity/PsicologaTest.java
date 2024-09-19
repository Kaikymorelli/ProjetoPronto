package com.teste.projetosaude.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ProjetoSaude.entities.Psicologa;

class PsicologaTest {

	private Psicologa psicologa;

	@BeforeEach
	void setUp() {
		psicologa = new Psicologa(1L, "Natalia", "natalia@gmail.com", "12345", "1234");
	}

	@Test
	@DisplayName("Testando o id")
	void testId() {
		psicologa.setId(2L);
		// Assert
		Assertions.assertEquals(2L, psicologa.getId());
	}

	@Test
	@DisplayName("Testando o nome")
	void testNome() {
		psicologa.setNome("Natalia");
		// Assert
		Assertions.assertEquals("Natalia", psicologa.getNome());
	}

	@Test
	@DisplayName ("Testando o email")
	void testEmail() {
		psicologa.setEmail("natalia@gmail.com");
		//Assert
		Assertions.assertEquals("natalia@gmail.com",psicologa.getEmail());
	}

	@Test
	@DisplayName("Testando a senha")
	void testSenha() {
		psicologa.setSenha("12345");
		// Assert
		Assertions.assertEquals("12345", psicologa.getSenha());
	}

	@Test
	@DisplayName("Testando o cfp")
	void testCpf() {
		psicologa.setCfp("1234");
		// Assert
		Assertions.assertEquals("1234", psicologa.getCfp());
	}

	@Test
	@DisplayName("Testando o construtor")
	void testConstrutorAll() {
		Psicologa novoPsicologa = new Psicologa(3L, "Natalia", "natalia@gmail.com", "12345", "1234");
		Assertions.assertAll("novoPsicologa", () -> Assertions.assertEquals(3L, novoPsicologa.getId()),
				() -> Assertions.assertEquals("Natalia", novoPsicologa.getNome()),
				() -> Assertions.assertEquals("natalia@gmail.com", novoPsicologa.getEmail()),
				() -> Assertions.assertEquals("12345", novoPsicologa.getSenha()),
				() -> Assertions.assertEquals("1234", novoPsicologa.getCfp()));

	}
}
