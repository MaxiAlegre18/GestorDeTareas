package com.aprendiendospring.tareas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aprendiendospring.tareas.domain.entidades.ListaDeTarea;

public interface ListaDeTareaRepository extends JpaRepository<ListaDeTarea, UUID> {

}
