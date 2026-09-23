package com.example.eurosupply.food;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.example.eurosupply.Unit;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

public class FoodDTO {

  @Getter
  private String name;

  @Getter
  private Integer quantity;

  @Getter
  @Enumerated(EnumType.STRING)
  @JdbcTypeCode(SqlTypes.NAMED_ENUM)
  private Unit unit;
}