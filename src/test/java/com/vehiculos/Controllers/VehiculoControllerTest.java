package com.vehiculos.Controllers;

import com.vehiculos.controller.VehiculoController;
import com.vehiculos.model.Combustion;
import com.vehiculos.model.Electrico;
import com.vehiculos.model.Hibrido;
import com.vehiculos.model.Vehiculo;
import com.vehiculos.service.VehiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VehiculoControllerTest {

    @InjectMocks
    private VehiculoController vehiculoController;

    @Mock
    private VehiculoService vehiculoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test // Esta prueba está diseñada para fallar
    void testGetAllVehiculos() {
        Vehiculo v1 = new Electrico();
        Vehiculo v2 = new Combustion();
        when(vehiculoService.getAllVehiculos()).thenReturn(Arrays.asList(v1, v2));

        List<Vehiculo> result = vehiculoController.getAllVehiculos();

        // Esto provocará un error porque el tamaño real es 2, no 3
        assertEquals(3, result.size());
        verify(vehiculoService, times(1)).getAllVehiculos();
    }

    @Test
    void testGetVehiculoById_Found() {
        Vehiculo v = new Electrico();
        when(vehiculoService.getVehiculoById(1L)).thenReturn(Optional.of(v));

        ResponseEntity<Vehiculo> response = vehiculoController.getVehiculoById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(v, response.getBody());
    }

    @Test
    void testGetVehiculoById_NotFound() {
        when(vehiculoService.getVehiculoById(2L)).thenReturn(Optional.empty());

        ResponseEntity<Vehiculo> response = vehiculoController.getVehiculoById(2L);

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void testCreateElectrico() {
        Electrico electrico = new Electrico();
        when(vehiculoService.saveVehiculo(electrico)).thenReturn(electrico);

        Electrico result = vehiculoController.createElectrico(electrico);

        assertEquals(electrico, result);
        verify(vehiculoService, times(1)).saveVehiculo(electrico);
    }
}
