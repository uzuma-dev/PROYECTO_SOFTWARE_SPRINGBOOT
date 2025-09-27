package com.vehiculos.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ELECTRICO")
public class Electrico extends Vehiculo implements AutonomoAvanzado{
    private double capacidadBateria; // kWh
    private int nivelAutonomia; // 0..5
    
    public Electrico() {
    }
    
    public Electrico(String marca, String modelo, int anio, double velocidadMaxima,
                     double capacidadBateria, int nivelAutonomia) {
        super(marca, modelo, anio, velocidadMaxima);
        this.capacidadBateria = capacidadBateria;
        this.nivelAutonomia = nivelAutonomia;
    }
    
    // Getters y Setters
    public double getCapacidadBateria() {
        return capacidadBateria;
    }
    
    public void setCapacidadBateria(double capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }
    
    public int getNivelAutonomia() {
        return nivelAutonomia;
    }
    
    public void setNivelAutonomia(int nivelAutonomia) {
        this.nivelAutonomia = nivelAutonomia;
    }
    
    // Métodos específicos
    public void cargar(double porcentaje) {
        System.out.println(getMarca() + " " + getModelo() + " cargando batería en " + porcentaje + "% (capacidad: "
                + capacidadBateria + "kWh)");
    }

    @Override
    public void activarPilotoAutomatico() {
        System.out.println(getMarca() + " " + getModelo() + " -> piloto automático activado (nivel " + nivelAutonomia + ").");
    }

    @Override
    public void desactivarPilotoAutomatico() {
        System.out.println(getMarca() + " " + getModelo() + " -> piloto automático desactivado.");
    }
    
    @Override
    public void asistenciaEmergencia() {
        System.out.println(getMarca() + " " + getModelo() + " -> asistencia de emergencia ACTIVADA.");
    }
    
    public void conducir() {
        System.out.println(getMarca() + " " + getModelo() + " se conduce manualmente.");
    }
}