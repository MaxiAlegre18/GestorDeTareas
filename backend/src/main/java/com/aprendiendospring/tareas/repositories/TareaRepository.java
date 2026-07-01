package com.aprendiendospring.tareas.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aprendiendospring.tareas.domain.entidades.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, UUID> {

    List<Tarea> findByListaDeTareaId(UUID idListaDeTarea);

    Optional<Tarea> findByListaDeTareaIdAndId(UUID idListaDeTarea, UUID id);

}
