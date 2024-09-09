package com.caua.rotasdroneapi.services;

import com.caua.rotasdroneapi.repositories.PlanejadorDeRotasDoDroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class PlanejadorDeRotasDoDroneService {
    @Autowired
    private PlanejadorDeRotasDoDroneRepository repository;

    @Autowired
    public PlanejadorDeRotasDoDroneService(PlanejadorDeRotasDoDroneRepository repository) {
        this.repository = repository;
    }

    public ArrayList<ArrayList<String>> gerarCiclos(String inicio) {
        return repository.gerarRotasDoDrone(inicio);
    }
}
