package Service;

import Model.Consulta;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaService {
    private final List<Consulta> consultas = new ArrayList<>();

    public void agendarConsulta(String paciente, String dataHoraTexto) {
        System.out.println("Agendando consulta para " + paciente + " em " + dataHoraTexto);
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraTexto);
        Consulta c = new Consulta(paciente, dataHora);
        consultas.add(c);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void listarConsultas() {
        for (Consulta c : consultas) {
            System.out.println("- " + c.getPaciente() + " em " + c.getDataHora());
        }
    }
}
