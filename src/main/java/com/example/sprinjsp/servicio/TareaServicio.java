package com.example.sprinjsp.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprinjsp.interfaceServicio.*;
import com.example.sprinjsp.interfaces.ITarea;
import com.example.sprinjsp.modelo.Tarea;

@Service
public class TareaServicio implements ITareaServicio{
    
    @Autowired
    private ITarea repo;

	@Override
	public List<Tarea> listar() {
		return (List<Tarea>)repo.findAll();
	}

	@Override
	public Optional<Tarea> listarId(int id) {
		return repo.findById(id);
	}

	@Override
	public int guardar(Tarea p) {
		Tarea em = repo.save(p);
		if(!em.equals(null)){
			return 1;
		}
		return 0;
	}

	@Override
	public void borrar(int id) {
		repo.deleteById(id);		
	}

    @Override
    public List<Tarea> buscarPorDescripcion(String descripcion) {
    List<Tarea> tareas = (List<Tarea>) repo.findAll();
    List<Tarea> tareasConDescripcion = new ArrayList<>();

    for (Tarea tarea : tareas) {
        if (tarea.getDescripcion().contains(descripcion)) {
            tareasConDescripcion.add(tarea);
        }
    }
    return tareasConDescripcion;
    }
}
