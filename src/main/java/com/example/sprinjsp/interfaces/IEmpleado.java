package com.example.sprinjsp.interfaces;

    
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sprinjsp.modelo.Empleado;

@Repository
public interface IEmpleado extends CrudRepository<Empleado, Integer>{

}