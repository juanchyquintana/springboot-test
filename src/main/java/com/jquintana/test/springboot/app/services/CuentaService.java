package com.jquintana.test.springboot.app.services;

import com.jquintana.test.springboot.app.models.Cuenta;

import java.math.BigDecimal;
import java.util.Optional;

public interface CuentaService {
    Cuenta findById(Long id);

    int revisarTotalTransferencias(Long idBanco);

    BigDecimal revisarSaldo(Long idCuenta);

    void transferir(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal monto, Long bancoId);

    Optional<Cuenta> findByPersona(String persona);
}
