package com.teste.projetosaude.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ProjetoSaude.entities.Agendamentos;
import com.ProjetoSaude.entities.Aluno;
import com.ProjetoSaude.entities.Psicologa;

class AgendamentosTest {

	private Aluno aluno;
	private Psicologa psicologa;
	private Agendamentos agendamentos;

	@BeforeEach
	public void setUp() {
		// Arrange
		agendamentos = new Agendamentos(1L, "Beatriz", "beatriz@gmail.com", "31/10/2022", "13h00",  aluno, psicologa);
	}

	@Test
	public void testId() {
		// Act: Atribui o valor ao atributo 'id'
		agendamentos.setId(2L);

		// Assert: Verifica se o valor foi corretamente atribuido
		Assertions.assertEquals(2L, agendamentos.getId(), "O ID deve ser igual ao valor atribuido");
	}

	@Test
	public void testAluno() {

		// Act:
		agendamentos.setAluno(aluno);

		// Assert:
		Assertions.assertEquals(aluno, agendamentos.getAluno(), "O aluno deve ser igual ao valor atribuido");

	}

	@Test
	public void testPsicologa() {

		// Act:
		agendamentos.setPsicologa(psicologa);

		// Assert:
		Assertions.assertEquals(psicologa, agendamentos.getPsicologa(), "O quarto deve ser igual ao valor atribuido");

	}

	@Test
	public void testNome() {
		// Act:
		agendamentos.setNome("Beatriz");

		// Assert:
		Assertions.assertEquals("Beatriz", agendamentos.getNome(), "O nome deve ser igual ao valor atribuído");
	}

	@Test
	public void testEmail() {
		// Act:
		agendamentos.setEmail("beatriz@gmail.com");

		// Assert:
		Assertions.assertEquals("beatriz@gmail.com", agendamentos.getEmail(),
				"O email deve ser igual ao valor atribuido");

	}

	@Test
	public void testData() {
		// Act:
		agendamentos.setData("31/10/2022");

		// Assert:
		Assertions.assertEquals("31/10/2022", agendamentos.getData(), "A data  deve ser igual ao valor atribuido");

	}

	@Test
	public void testHorario() {
		// Act:
		agendamentos.setHorario("13h00");

		// Assert:
		Assertions.assertEquals("13h00", agendamentos.getHorario(), "A data  deve ser igual ao valor atribuido");

	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		// Act
		Agendamentos novaAgendamentos = new Agendamentos(1L, "Beatriz", "beatriz@gmail.com", "31/10/2022", "13h00",
				aluno, psicologa);
		// Assertion
		Assertions.assertAll("novaAgendamentos", () -> Assertions.assertEquals(1L, novaAgendamentos.getId()),
				() -> Assertions.assertEquals("Beatriz", novaAgendamentos.getNome()),
				() -> Assertions.assertEquals("beatriz@gmail.com", novaAgendamentos.getEmail()),
				() -> Assertions.assertEquals("31/10/2022", novaAgendamentos.getData()),
				() -> Assertions.assertEquals("13h00", novaAgendamentos.getHorario()),
				() -> Assertions.assertEquals(aluno, novaAgendamentos.getAluno()),
				() -> Assertions.assertEquals(psicologa, novaAgendamentos.getPsicologa()));

	}

}
