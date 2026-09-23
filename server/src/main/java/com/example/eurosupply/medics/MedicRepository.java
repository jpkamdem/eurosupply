package com.example.eurosupply.medics;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<Medic, UUID> {

}