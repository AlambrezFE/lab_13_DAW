package com.example.sprinjsp.modelo;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleado")

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Column(name ="nombre")
    private String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Column(name ="rol")
    private String rol;

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    @OneToMany
    private List<Tarea> tarea;

    public List<Tarea> getTarea() {
        return tarea;
    }

    public void setTarea(List<Tarea> tarea) {
        this.tarea = tarea;
    }
}




