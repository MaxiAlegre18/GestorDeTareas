package com.aprendiendospring.tareas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aprendiendospring.tareas.domain.entidades.ListaDeTarea;

@Repository
public interface RepositorioListaDeTarea extends JpaRepository<ListaDeTarea, UUID> {

}
