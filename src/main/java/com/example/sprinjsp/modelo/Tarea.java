package com.example.sprinjsp.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Column(name = "descripcion")
    private String descripcion;

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Column(name = "realizado")
    private boolean realizado;

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public boolean isRealizado() {
        return realizado;
    }

    @Column(name = "fecha")
    private Date fecha;

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

}
