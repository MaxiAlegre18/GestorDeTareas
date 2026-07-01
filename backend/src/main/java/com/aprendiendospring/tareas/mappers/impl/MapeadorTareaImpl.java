package com.aprendiendospring.tareas.mappers.impl;

import org.springframework.stereotype.Component;

import com.aprendiendospring.tareas.domain.dto.TareaDTO;
import com.aprendiendospring.tareas.domain.entidades.Tarea;
import com.aprendiendospring.tareas.mappers.MapeadorTarea;

@Component
public class MapeadorTareaImpl implements MapeadorTarea {

    @Override
    public Tarea convertirDesdeDTO(TareaDTO tareaDTO) {
        return new Tarea(
                tareaDTO.id(),
                tareaDTO.titulo(),
                tareaDTO.descripcion(),
                tareaDTO.fechaExpiracion(),
                tareaDTO.estadoTarea(),
                tareaDTO.prioridadTarea(),
                null,
                null,
                null);
    }

    @Override
    public TareaDTO convertirHaciaDTO(Tarea tarea) {
        return new TareaDTO(
                tarea.getId(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getFechaExpiracion(),
                tarea.getPrioridad(),
                tarea.getEstado());
    }

}
