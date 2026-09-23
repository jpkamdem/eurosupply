package com.example.eurosupply.medics;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;

public class MedicDTO {

  @Getter
  private UUID id;

  @Getter
  private String name;

  @Getter
  private Integer quantity;

  @Getter
  private Instant expiration;
}