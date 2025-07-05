import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Service.ConsultaService;
import Model.Consulta;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultaServiceTest {

    private ConsultaService service;

    @BeforeEach
    void setup() {
        service = new ConsultaService();
    }

    @Test
    void deveAgendarConsulta() {
        service.agendarConsulta("Ana", "2025-06-25T10:00");
        List<Consulta> consultas = service.getConsultas();
        assertEquals(1, consultas.size());
        assertEquals("Ana", consultas.get(0).getPaciente());
    }

    @Test
    void listaDeveComecarVazia() {
        assertTrue(service.getConsultas().isEmpty());
    }
}
