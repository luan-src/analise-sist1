package Service;

import br.faccat.clinica_selenium.Paciente;
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
    public void adicionarConsultaAoPaciente(String cpf, Consulta consulta) {
        Paciente paciente = pacienteRepository.findByCpf(cpf);
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente não encontrado com o CPF: " + cpf);
        }
        consulta.setPaciente(paciente); // se houver relação
        consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultasPorCpf(String cpf) {
        Paciente paciente = pacienteRepository.findByCpf(cpf);
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente não encontrado.");
        }
        return consultaRepository.findByPaciente(paciente);
    }

}
