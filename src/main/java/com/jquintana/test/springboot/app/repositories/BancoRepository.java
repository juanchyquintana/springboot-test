package com.jquintana.test.springboot.app.repositories;

import com.jquintana.test.springboot.app.models.Banco;
import com.jquintana.test.springboot.app.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BancoRepository extends JpaRepository<Banco, Long> {
}
