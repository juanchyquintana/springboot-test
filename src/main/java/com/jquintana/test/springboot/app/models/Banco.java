package com.jquintana.test.springboot.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int totalTransferencia;

    public Banco() {
    }

    public Banco(Long id, String nombre, int totalTransferencia) {
        this.id = id;
        this.nombre = nombre;
        this.totalTransferencia = totalTransferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalTransferencia() {
        return totalTransferencia;
    }

    public void setTotalTransferencia(int totalTransferencia) {
        this.totalTransferencia = totalTransferencia;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Banco banco = (Banco) o;
        return totalTransferencia == banco.totalTransferencia && Objects.equals(id, banco.id) && Objects.equals(nombre, banco.nombre);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(nombre);
        result = 31 * result + totalTransferencia;
        return result;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", totalTransferencia=" + totalTransferencia +
                '}';
    }
}
