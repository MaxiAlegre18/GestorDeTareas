package com.aprendiendospring.tareas.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aprendiendospring.tareas.domain.entidades.Tarea;

@Repository
public interface RepositorioTarea extends JpaRepository<Tarea, UUID> {

    List<Tarea> encontrarPorListaDeTareaId(UUID idListaDeTarea);

    Optional<Tarea> encontrarPorListaDeTareaIdYTareaId(UUID idListaDeTarea, UUID id);

}
