package com.github.thg.bankapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.thg.bankapi.entities.Transfer;


public interface TransferRepository extends JpaRepository<Transfer,Long> {

}
