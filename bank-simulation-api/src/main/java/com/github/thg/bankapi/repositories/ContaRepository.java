package com.github.thg.bankapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.thg.bankapi.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
