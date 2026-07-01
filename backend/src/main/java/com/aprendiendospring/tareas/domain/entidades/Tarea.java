package com.aprendiendospring.tareas.domain.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Entity marca la clase como una entidad JPA
@Entity
// Permite especificar el nombre de la tabla de la base de datos
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    // Todo el tiempo que creemos una tarea con un id == null, JPA generara
    // automaticamente un UUID y este sera el valor de la variable
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_expiracion")
    private LocalDateTime fechaExpiracion;

    @Column(name = "estado", nullable = false)
    private EstadoTarea estado;

    @Column(name = "prioridad", nullable = false)
    private PrioridadTarea prioridad;

    // FetchType.LAZY: La lista de tareas no sera obtenida de la base de datos a
    // menos que sea requerida
    @ManyToOne(fetch = FetchType.LAZY)
    // Especifica el nombre de la columna de la FK de lista de tarea
    @JoinColumn(name = "lista_de_tarea_id")
    private ListaDeTarea listaDeTarea;

    @Column(name = "creado", nullable = false)
    private LocalDateTime creado;

    @Column(name = "actualizado", nullable = false)
    private LocalDateTime actualizado;

    public Tarea() {

    }

    public Tarea(UUID id, String titulo, String descripcion, LocalDateTime fechaExpiracion, EstadoTarea estado,
            PrioridadTarea prioridad, ListaDeTarea listaDeTarea, LocalDateTime creado, LocalDateTime actualizado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaExpiracion = fechaExpiracion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.listaDeTarea = listaDeTarea;
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

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public PrioridadTarea getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadTarea prioridad) {
        this.prioridad = prioridad;
    }

    public ListaDeTarea getListaDeTarea() {
        return listaDeTarea;
    }

    public void setListaDeTarea(ListaDeTarea listaDeTarea) {
        this.listaDeTarea = listaDeTarea;
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
        result = prime * result + ((fechaExpiracion == null) ? 0 : fechaExpiracion.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((prioridad == null) ? 0 : prioridad.hashCode());
        result = prime * result + ((listaDeTarea == null) ? 0 : listaDeTarea.hashCode());
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
        Tarea other = (Tarea) obj;
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
        if (fechaExpiracion == null) {
            if (other.fechaExpiracion != null)
                return false;
        } else if (!fechaExpiracion.equals(other.fechaExpiracion))
            return false;
        if (estado != other.estado)
            return false;
        if (prioridad != other.prioridad)
            return false;
        if (listaDeTarea == null) {
            if (other.listaDeTarea != null)
                return false;
        } else if (!listaDeTarea.equals(other.listaDeTarea))
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
        return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaExpiracion="
                + fechaExpiracion + ", estado=" + estado + ", prioridad=" + prioridad + ", listaDeTarea=" + listaDeTarea
                + ", creado=" + creado + ", actualizado=" + actualizado + "]";
    }

}
