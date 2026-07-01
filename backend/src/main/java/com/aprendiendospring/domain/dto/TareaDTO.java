package com.aprendiendospring.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.aprendiendospring.domain.entidades.EstadoTarea;
import com.aprendiendospring.domain.entidades.PrioridadTarea;

public record TareaDTO(
        UUID id,
        String titulo,
        String descripcion,
        LocalDateTime fechaExpiracion,
        PrioridadTarea prioridadTarea,
        EstadoTarea estadoTarea) {

}
