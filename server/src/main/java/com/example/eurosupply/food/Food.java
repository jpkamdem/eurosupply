package com.example.eurosupply.food;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Food {
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
  private short quantity;
}