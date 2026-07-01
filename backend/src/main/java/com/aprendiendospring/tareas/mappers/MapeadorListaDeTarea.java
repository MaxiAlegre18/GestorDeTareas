package com.aprendiendospring.tareas.mappers;

import com.aprendiendospring.tareas.domain.dto.ListaDeTareaDTO;
import com.aprendiendospring.tareas.domain.entidades.ListaDeTarea;

public interface MapeadorListaDeTarea {

    ListaDeTarea convertirDesdeDTO(ListaDeTareaDTO listaDeTareaDTO);

    ListaDeTareaDTO convertirHaciaDTO(ListaDeTarea listaDeTarea);
}
