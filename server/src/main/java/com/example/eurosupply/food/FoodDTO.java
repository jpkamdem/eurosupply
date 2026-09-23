package com.example.eurosupply.food;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.example.eurosupply.Unit;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

public class FoodDTO {

  @Getter
  @Column(nullable = false, unique = true)
  private String name;

  @Getter
  @Column(nullable = false)
  private int quantity;

  @Getter
  @Enumerated(EnumType.STRING)
  @JdbcTypeCode(SqlTypes.NAMED_ENUM)
  @Column(nullable = false)
  private Unit unit;
}