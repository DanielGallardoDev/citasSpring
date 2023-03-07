package com.helloworld.citasSpring.service.Impl;

import com.helloworld.citasSpring.domain.Cita;
import com.helloworld.citasSpring.repository.CitaRepository;
import com.helloworld.citasSpring.service.CitaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CitaServiceImpl implements CitaService {

    CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public void alta(Cita cita){
        citaRepository.alta(cita);
    }

    public void baja (int id){
        citaRepository.baja(id);
    }

    public List<Cita> listar(){
        return citaRepository.listar();
    }
}
