package Controller;

import Service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> agendar(@RequestParam String cpf,
                                          @RequestParam String nome,
                                          @RequestParam String dataHora) {
        service.agendarConsulta(cpf, nome, dataHora);
        return ResponseEntity.ok("Consulta agendada para " + nome + " (CPF: " + cpf + ") em " + dataHora);
    }
}
