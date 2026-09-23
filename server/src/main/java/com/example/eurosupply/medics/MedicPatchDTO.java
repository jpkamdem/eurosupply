package com.example.eurosupply.medics;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class MedicPatchDTO {

  @Getter
  @Setter
  private Optional<UUID> id = Optional.empty();

  @Getter
  @Setter
  private Optional<@Size(max = 75) String> name = Optional.empty();

  @Getter
  @Setter
  private Optional<@Min(0) Integer> quantity = Optional.empty();

  @Getter
  @Setter
  private Optional<Instant> expiration = Optional.empty();
}