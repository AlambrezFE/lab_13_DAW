package com.example.sprinjsp.servicio;

import java.util.List;
import java.util.Optional;

import com.example.sprinjsp.modelo.Empleado;

public interface IEmpleadoServicio {
    public List<Empleado> listar();
    public Optional<Empleado> listarId(int id);
    public int guardar(Empleado p);
    public void borrar(int id);
    public List<Empleado> buscarPorNombre(String nombre);
}
