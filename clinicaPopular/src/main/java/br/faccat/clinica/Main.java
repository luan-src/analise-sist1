package br.faccat.clinica;

import Service.ConsultaService;

public class Main {
    public static void main(String[] args) {
        ConsultaService service = new ConsultaService();
        service.agendarConsulta("João", "2025-06-30T09:00");
        service.agendarConsulta("Maria", "2025-07-01T14:00");
        service.listarConsultas();
    }
}
