package com.caua.rotasdroneapi.controllers;

import com.caua.rotasdroneapi.DTO.EntradaDTO;
import com.caua.rotasdroneapi.services.PlanejadorDeRotasDoDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rotas")
public class PlanejadorDeRotasDoDroneController {

    @Autowired
    private PlanejadorDeRotasDoDroneService service;

    @PostMapping("/gerar")
    public ArrayList<ArrayList<String>> gerarCiclos(@RequestBody EntradaDTO entradaDTO) {
        return service.gerarCiclos(entradaDTO.getEntrada());
    }
}
