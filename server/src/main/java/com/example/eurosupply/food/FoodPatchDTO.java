package com.example.eurosupply.food;

import java.util.Optional;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.example.eurosupply.Unit;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class FoodPatchDTO {

  @Getter
  @Setter 
  private Optional<@Size(max = 75) String> name = Optional.empty();

  @Getter
  @Setter
  private Optional<@Min(0) Integer> quantity = Optional.empty();

  @Getter
  @Enumerated(EnumType.STRING)
  @JdbcTypeCode(SqlTypes.NAMED_ENUM)
  private Optional<Unit> unit = Optional.empty();
}