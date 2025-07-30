package com.jquintana.test.springboot.app;

import com.jquintana.test.springboot.app.models.Cuenta;
import com.jquintana.test.springboot.app.repositories.CuentaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IntegracionJpaTest{
    @Autowired
    CuentaRepository cuentaRepository;

    @Test
    void testFindById() {
        Optional<Cuenta> cuenta = cuentaRepository.findById(1L);
        assertTrue(cuenta.isPresent());
        assertEquals("Juan", cuenta.orElseThrow().getPersona());
    }

    @Test
    void testFindByPersona() {
        Optional<Cuenta> cuenta = cuentaRepository.findByPersona("Diego");
        assertTrue(cuenta.isPresent());
        assertEquals("Diego", cuenta.orElseThrow().getPersona());
        assertEquals("2000.00", cuenta.orElseThrow().getSaldo().toPlainString());
    }

    @Test
    void testFindByPersonaThrowException() {
        Optional<Cuenta> cuenta = cuentaRepository.findByPersona("Pedro");
        assertThrows(NoSuchElementException.class, cuenta::orElseThrow);
        assertFalse(cuenta.isPresent());
    }

    @Test
    void testFindAll() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        assertFalse(cuentas.isEmpty());
        assertEquals(2, cuentas.size());
    }

    @Test
    void testSave() {
        // Given
        Cuenta newCuenta = new Cuenta(null,"Pepe", new BigDecimal("3000"));

        // When
        Cuenta cuenta = cuentaRepository.save(newCuenta);
        // Cuenta cuenta = cuentaRepository.findByPersona("Pepe").orElseThrow();
        // Cuenta cuenta = cuentaRepository.findById(save.getId()).orElseThrow();

        // Then
        assertEquals("Pepe", cuenta.getPersona());
        assertEquals("3000", cuenta.getSaldo().toPlainString());
        // assertEquals(3L, pepe.getId());
    }

    @Test
    void testUpdate() {
        // Given
        Cuenta newCuenta = new Cuenta(null,"Pepe", new BigDecimal("3000"));

        // When
        Cuenta cuenta = cuentaRepository.save(newCuenta);
        // Cuenta cuenta = cuentaRepository.findByPersona("Pepe").orElseThrow();
        // Cuenta cuenta = cuentaRepository.findById(save.getId()).orElseThrow();

        // Then
        assertEquals("Pepe", cuenta.getPersona());
        assertEquals("3000", cuenta.getSaldo().toPlainString());
        // assertEquals(3L, pepe.getId());

        cuenta.setSaldo(new BigDecimal("3800"));
        Cuenta cuentaActualizada = cuentaRepository.save(cuenta);

        assertEquals("Pepe", cuentaActualizada.getPersona());
        assertEquals("3800", cuentaActualizada.getSaldo().toPlainString());
    }

    @Test
    void testDelete() {
        Cuenta cuenta = cuentaRepository.findById(2L).orElseThrow();
        assertEquals("Diego", cuenta.getPersona());

        cuentaRepository.delete(cuenta);

        assertThrows(NoSuchElementException.class, () -> {
            cuentaRepository.findById(2L).orElseThrow();
        });
        assertEquals(1, cuentaRepository.findAll().size());
    }
}
