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
    public ResponseEntity<String> agendar(@RequestParam String paciente,
                                          @RequestParam String dataHora) {
        service.agendar(paciente, dataHora);
        return ResponseEntity.ok("Consulta agendada para " + paciente + " em " + dataHora);
    }
}
