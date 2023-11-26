package com.example.sprinjsp.interfaces;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sprinjsp.modelo.Tarea;

@Repository
public interface ITarea extends CrudRepository<Tarea, Integer>{
 
}
