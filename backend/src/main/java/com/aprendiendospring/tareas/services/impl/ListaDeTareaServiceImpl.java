package com.aprendiendospring.tareas.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aprendiendospring.tareas.domain.entidades.ListaDeTarea;
import com.aprendiendospring.tareas.repositories.ListaDeTareaRepository;
import com.aprendiendospring.tareas.services.ListaDeTareaService;

@Service
public class ListaDeTareaServiceImpl implements ListaDeTareaService {

    private final ListaDeTareaRepository listaDeTareaRepository;

    public ListaDeTareaServiceImpl(ListaDeTareaRepository listaDeTareaRepository) {
        this.listaDeTareaRepository = listaDeTareaRepository;
    }

    @Override
    public List<ListaDeTarea> obtenerListasDeTareas() {
        return listaDeTareaRepository.findAll();
    }

}
