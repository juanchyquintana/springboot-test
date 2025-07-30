package com.jquintana.test.springboot.app.data;

import com.jquintana.test.springboot.app.models.Banco;
import com.jquintana.test.springboot.app.models.Cuenta;

import java.math.BigDecimal;
import java.util.Optional;

public class Datos {
//    public static final Cuenta CUENTA_001 = new Cuenta(1L, "Juan", new BigDecimal(1000));
//    public static final Cuenta CUENTA_002 = new Cuenta(2L, "Diego", new BigDecimal(2000));
//    public static final Banco BANCO_001 = new Banco(1L, "Rocco Banck", 0);

    public static Optional<Cuenta> crearCuenta001() {
        return Optional.of(new Cuenta(1L, "Juan", new BigDecimal(1000)));
    }

    public static Optional<Cuenta> crearCuenta002() {
        return Optional.of(new Cuenta(2L, "Diego", new BigDecimal(2000)));
    }

    public static Optional<Banco> crearBanco() {
        return Optional.of(new Banco(1L, "Rocco Bank", 0));
    }
}
