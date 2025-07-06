package br.faccat.clinica_selenium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import Model.Consulta;
import Service.ConsultaService;

@SpringBootTest
class ClinicaSeleniumApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testAssociarConsultaAPacientePorCpf() {
		Paciente paciente = new Paciente();
		paciente.setNome("Maria");
		paciente.setCpf("12345678900");

		pacienteRepository.save(paciente);

		Consulta consulta = new Consulta();
		consulta.setDescricao("Consulta de rotina");

		ConsultaService.adicionarConsultaAoPaciente("12345678900", consulta);

		List<Consulta> consultas = ConsultaService.listarConsultasPorCpf("12345678900");
		assertEquals(1, consultas.size());
		assertEquals("Consulta de rotina", consultas.get(0).getDescricao());
	}

}
