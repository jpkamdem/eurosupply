package com.example.eurosupply.material;

import java.util.Optional;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class MaterialPatchDTO {

  @Getter
  @Setter 
  private Optional<@Size(max = 75) String> name = Optional.empty();

  @Getter
  @Setter
  private Optional<@Min(0) Integer> quantity = Optional.empty();
}