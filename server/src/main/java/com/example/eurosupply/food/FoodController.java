package com.example.eurosupply.food;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/food")
public class FoodController {
  private final FoodService foodService;

  public FoodController(FoodService foodService) {
    this.foodService = foodService;
  }

  @GetMapping("/")
  ResponseEntity<?> index() {
    List<Food> foods = foodService.index();
    return new ResponseEntity<>(foods, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  ResponseEntity<?> show(@PathVariable UUID id) throws NoSuchElementException {
    Food foundFood = foodService.show(id);
    return new ResponseEntity<>(foundFood, HttpStatus.OK);
  }

  @PostMapping("/")
  ResponseEntity<?> store(@RequestBody @Valid FoodDTO foodDTO) throws IllegalArgumentException {
    Food newFood = foodService.store(foodDTO);
    return new ResponseEntity<>(newFood, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid FoodDTO foodDTO) throws NoSuchElementException {
    foodService.update(foodDTO, id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<?> delete(@PathVariable UUID id) throws NoSuchElementException {
    foodService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}