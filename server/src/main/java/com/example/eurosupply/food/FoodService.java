package com.example.eurosupply.food;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class FoodService {
  private final FoodRepository foodRepository;

  public FoodService(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  public List<Food> index() {
    List<Food> foods = foodRepository.findAll();
    return foods;
  }

  public Food show(UUID id) throws NoSuchElementException {
    Food food = foodRepository.findById(id).orElseThrow();
    return food;
  }

  public Food store(FoodDTO newFood) throws IllegalArgumentException {
    Food food = new Food();
    food.setName(newFood.getName());
    food.setQuantity(newFood.getQuantity());
    food.setUnit(newFood.getUnit());
    foodRepository.save(food);
    return food;
  }

  public Food update(FoodDTO food, UUID id) throws NoSuchElementException {
    Food foundFood = foodRepository.findById(id).orElseThrow();
    foundFood.setName(food.getName());
    foundFood.setQuantity(food.getQuantity());
    foundFood.setUnit(food.getUnit());
    foodRepository.save(foundFood);
    return foundFood;
  }

  public void delete(UUID id) {
    foodRepository.deleteById(id);
  }
}