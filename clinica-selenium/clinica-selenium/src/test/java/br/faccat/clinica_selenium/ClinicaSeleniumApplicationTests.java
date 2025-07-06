package br.faccat.clinica_selenium;

import Model.Consulta;
import Model.Paciente;
import Service.ConsultaService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClinicaSeleniumApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testAssociarConsultaAPacientePorCpf() {
		// Instância do serviço
		ConsultaService service = new ConsultaService();

		// Agendar consulta para o CPF
		service.agendarConsulta("12345678900", "Maria", "2025-07-06T09:00");

		// Buscar as consultas do paciente
		List<Consulta> consultas = service.listarConsultasPorCpf("12345678900");

		// Verificações
		assertEquals(1, consultas.size());
		assertEquals("Maria", consultas.get(0).getPaciente());
	}
}
