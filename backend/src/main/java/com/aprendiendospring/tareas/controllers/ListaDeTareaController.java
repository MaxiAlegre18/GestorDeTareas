package com.aprendiendospring.tareas.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendiendospring.tareas.domain.dto.ListaDeTareaDTO;
import com.aprendiendospring.tareas.mappers.ListaDeTareaMapper;
import com.aprendiendospring.tareas.services.ListaDeTareaService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/listas-de-tarea")
public class ListaDeTareaController {

    private final ListaDeTareaService listaDeTareaService;
    private final ListaDeTareaMapper listaDeTareaMapper;

    public ListaDeTareaController(ListaDeTareaService listaDeTareaService, ListaDeTareaMapper listaDeTareaMapper) {
        this.listaDeTareaService = listaDeTareaService;
        this.listaDeTareaMapper = listaDeTareaMapper;
    }

    @GetMapping
    public List<ListaDeTareaDTO> obtenerListaDeTareas() {
        return listaDeTareaService.obtenerListasDeTareas().stream()
                .map(listaDeTareaMapper::convertirHaciaDTO)
                .toList();
    }

}
