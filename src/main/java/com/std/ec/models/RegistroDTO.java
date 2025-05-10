package com.std.ec.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistroDTO implements Serializable {
    private String nombreCompleto;
    private String numeroAsiento;
    private String numeroTarjeta;
    private String emailConfirmacion;
    private String phone;

    // Getters y setters
}