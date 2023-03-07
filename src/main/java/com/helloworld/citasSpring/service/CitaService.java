package com.helloworld.citasSpring.service;

import com.helloworld.citasSpring.domain.Cita;

import java.util.List;

public interface CitaService {

   void alta(Cita cita);
   void baja (int id);
   List<Cita> listar();
}
