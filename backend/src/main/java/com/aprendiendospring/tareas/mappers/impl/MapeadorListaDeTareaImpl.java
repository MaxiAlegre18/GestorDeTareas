package com.aprendiendospring.tareas.mappers.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.aprendiendospring.tareas.domain.dto.ListaDeTareaDTO;
import com.aprendiendospring.tareas.domain.entidades.EstadoTarea;
import com.aprendiendospring.tareas.domain.entidades.ListaDeTarea;
import com.aprendiendospring.tareas.domain.entidades.Tarea;
import com.aprendiendospring.tareas.mappers.MapeadorListaDeTarea;
import com.aprendiendospring.tareas.mappers.MapeadorTarea;

@Component
public class MapeadorListaDeTareaImpl implements MapeadorListaDeTarea {

    private final MapeadorTarea mapeadorTarea;

    // Como esta clase esta marcada con @Component, durante la ejecucion, Spring le
    // inyectara un bean de MapeadorTarea
    public MapeadorListaDeTareaImpl(MapeadorTarea mapeadorTarea) {
        this.mapeadorTarea = mapeadorTarea;
    }

    @Override
    public ListaDeTarea convertirDesdeDTO(ListaDeTareaDTO listaDeTareaDTO) {

        return new ListaDeTarea(
                listaDeTareaDTO.id(),
                listaDeTareaDTO.titulo(),
                listaDeTareaDTO.descripcion(),
                Optional.ofNullable(listaDeTareaDTO.tareas())
                        .map(tareas -> tareas.stream()
                                .map(mapeadorTarea::convertirDesdeDTO)
                                .toList())
                        .orElse(
                                null),
                null,
                null

        );

    }

    @Override
    public ListaDeTareaDTO convertirHaciaDTO(ListaDeTarea listaDeTarea) {
        return new ListaDeTareaDTO(
                listaDeTarea.getId(),
                listaDeTarea.getTitulo(),
                listaDeTarea.getDescripcion(),
                Optional.ofNullable(listaDeTarea.getTareas())
                        .map(List::size)
                        .orElse(0),
                calcularProgresoListaDeTarea(listaDeTarea.getTareas()),
                Optional.ofNullable(listaDeTarea.getTareas())
                        .map(tareas -> tareas.stream().map(mapeadorTarea::convertirHaciaDTO).toList())
                        .orElse(null));
    }

    private Double calcularProgresoListaDeTarea(List<Tarea> tareas) {
        if (null == tareas) {
            return null;
        }
        long cantidadTareasCerradas = tareas.stream().filter(tarea -> EstadoTarea.CERRADO == tarea.getEstado()).count();
        return (double) cantidadTareasCerradas / tareas.size();
    }

}
