package com.example.eurosupply.medics;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medics")
public class Medic {

  @Id
  @Getter
  @GeneratedValue
  @Column(nullable = false, unique = true)
  private UUID id;

  @Getter
  @Setter
  @Column(nullable = false, unique = true)
  private String name;

  @Getter
  @Setter
  @Column(nullable = false)
  private Integer quantity;

  @Getter
  @Column(nullable = false, insertable = false, updatable = false)
  private Instant expiration;
}