package com.example.eurosupply.food;

import jakarta.persistence.Column;
import lombok.Getter;

public class FoodDTO {

  @Getter
  @Column(nullable = false, unique = true)
  private String name;

  @Getter
  @Column(nullable = false)
  private short quantity;
}