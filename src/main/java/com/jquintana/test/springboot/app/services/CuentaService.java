package com.jquintana.test.springboot.app.services;

import com.jquintana.test.springboot.app.models.Cuenta;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CuentaService {
    List<Cuenta> findAll();

    Cuenta findById(Long id);

    Cuenta save(Cuenta cuenta);

    int revisarTotalTransferencias(Long idBanco);

    BigDecimal revisarSaldo(Long idCuenta);

    void transferir(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal monto, Long bancoId);

    Optional<Cuenta> findByPersona(String persona);
}
