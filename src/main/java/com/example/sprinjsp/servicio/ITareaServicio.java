package com.example.sprinjsp.servicio;

import java.util.List;
import java.util.Optional;

import com.example.sprinjsp.modelo.Tarea;

public interface ITareaServicio {
    public List<Tarea> listar();
    public Optional<Tarea> listarId(int id);
    public int guardar(Tarea p);
    public void borrar(int id);
    public List<Tarea> buscarPorDescripcion(String descripcion);
} 
