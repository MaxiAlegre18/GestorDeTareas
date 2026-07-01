package com.aprendiendospring.tareas.domain.entidades;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lista_de_tareas")
public class ListaDeTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    // El atributo mappedBy indica la variable que tendra a la "FK" de la relacion
    // Cascade son operaciones cascada que son tareas que se replican en las tareas
    // hijas
    // En este caso, si la lista la elimino de la base de datos, todas las tareas
    // asociadas a esta lista se borraran
    // Con PERSIST, al crear una nueva lista y la añado tareas nuevas a la lista,
    // todas las tareas nuevas se guardan automaticamente en la base de datos
    @OneToMany(mappedBy = "listaDeTarea", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    private List<Tarea> tareas;

    @Column(name = "creado", nullable = false)
    private LocalDateTime creado;

    @Column(name = "actualizado", nullable = false)
    private LocalDateTime actualizado;

    public ListaDeTarea() {

    }

    public ListaDeTarea(UUID id, String titulo, String descripcion, List<Tarea> tareas, LocalDateTime creado,
            LocalDateTime actualizado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tareas = tareas;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public LocalDateTime getCreado() {
        return creado;
    }

    public void setCreado(LocalDateTime creado) {
        this.creado = creado;
    }

    public LocalDateTime getActualizado() {
        return actualizado;
    }

    public void setActualizado(LocalDateTime actualizado) {
        this.actualizado = actualizado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((tareas == null) ? 0 : tareas.hashCode());
        result = prime * result + ((creado == null) ? 0 : creado.hashCode());
        result = prime * result + ((actualizado == null) ? 0 : actualizado.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ListaDeTarea other = (ListaDeTarea) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (tareas == null) {
            if (other.tareas != null)
                return false;
        } else if (!tareas.equals(other.tareas))
            return false;
        if (creado == null) {
            if (other.creado != null)
                return false;
        } else if (!creado.equals(other.creado))
            return false;
        if (actualizado == null) {
            if (other.actualizado != null)
                return false;
        } else if (!actualizado.equals(other.actualizado))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ListaDeTarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", tareas=" + tareas
                + ", creado=" + creado + ", actualizado=" + actualizado + "]";
    };

}
