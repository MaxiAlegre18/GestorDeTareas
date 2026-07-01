package com.aprendiendospring.tareas.mappers;

import com.aprendiendospring.tareas.domain.dto.TareaDTO;
import com.aprendiendospring.tareas.domain.entidades.Tarea;

public interface MapeadorTarea {

    Tarea convertirDesdeDTO(TareaDTO tareaDTO);

    TareaDTO convertirHaciaDTO(Tarea tarea);
}
