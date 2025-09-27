package com.vehiculos.model;

/**
 * Interface que define el comportamiento avanzado de un vehículo autónomo.
 */
public interface AutonomoAvanzado extends Autonomo {

    /**
     * Proporciona asistencia en caso de emergencia mientras se conduce de forma autónoma.
     */
    void asistenciaEmergencia();
}
