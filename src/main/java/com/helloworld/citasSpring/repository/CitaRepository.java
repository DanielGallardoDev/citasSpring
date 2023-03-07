package com.helloworld.citasSpring.repository;

import com.helloworld.citasSpring.domain.Cita;

import java.util.List;

public interface CitaRepository {

    void alta(Cita cita);
    void baja (int id);
    List<Cita> listar();
}

