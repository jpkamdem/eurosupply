package com.example.eurosupply.food;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, UUID> {

}