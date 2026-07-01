package com.aprendiendospring.tareas.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.aprendiendospring.tareas.domain.entidades.EstadoTarea;
import com.aprendiendospring.tareas.domain.entidades.PrioridadTarea;

public record TareaDTO(
                UUID id,
                String titulo,
                String descripcion,
                LocalDateTime fechaExpiracion,
                PrioridadTarea prioridadTarea,
                EstadoTarea estadoTarea) {
}
