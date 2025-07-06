package Service;

import Model.Consulta;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {
    private final List<Consulta> consultas = new ArrayList<>();

    public Consulta agendar(String paciente, String dataHoraTexto) {
        LocalDateTime dt = LocalDateTime.parse(dataHoraTexto);
        Consulta c = new Consulta(paciente, dt);
        consultas.add(c);
        return c;
    }

    public List<Consulta> listar() {
        return new ArrayList<>(consultas);
    }
}
