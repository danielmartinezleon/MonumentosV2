package com.salesianostriana.dam.monumentosv2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Monumento {
    private Long id;
    private String codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private double latitud;
    private double longitud;
    private String nombre;
    private String descripcion;
    private String imagen;
}
