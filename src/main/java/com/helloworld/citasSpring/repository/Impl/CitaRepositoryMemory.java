package com.helloworld.citasSpring.repository.Impl;

import com.helloworld.citasSpring.domain.Cita;
import com.helloworld.citasSpring.repository.CitaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CitaRepositoryMemory  implements CitaRepository {

   private List<Cita>citas;

    public CitaRepositoryMemory() {
        citas = new ArrayList<>();
    }

    @Override
    public void alta(Cita cita) {
        citas.add(cita);
    }

    @Override
    public void baja(int id) {
        citas.remove(id);
    }

    @Override
    public List<Cita> listar() {
        return citas;
    }
}
