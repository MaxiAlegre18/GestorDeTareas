package com.aprendiendospring.domain.dto;

import java.util.List;
import java.util.UUID;

public record ListaDeTareaDTO(
        UUID id,
        String titulo,
        String descripcion,
        Integer cantidadTareas,
        Double progresoTareas,
        List<TareaDTO> tareas) {

}
