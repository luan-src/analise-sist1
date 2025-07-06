package Service;

import Model.Consulta;
import Model.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ConsultaService {

    private final Map<String, Paciente> pacientes = new HashMap<>();

    public Consulta agendarConsulta(String cpf, String nome, String dataHoraTexto) {
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraTexto);
        Consulta consulta = new Consulta(nome, dataHora);

        Paciente paciente = pacientes.get(cpf);

        if (paciente == null) {
            paciente = new Paciente(nome, cpf);
            pacientes.put(cpf, paciente);
        }

        paciente.adicionarConsulta(consulta);
        return consulta;
    }

    public List<Consulta> listarConsultasPorCpf(String cpf) {
        Paciente paciente = pacientes.get(cpf);
        if (paciente != null) {
            return paciente.getConsultas();
        }
        return Collections.emptyList();
    }

    public Paciente getPaciente(String cpf) {
        return pacientes.get(cpf);
    }
}

