package com.example.eurosupply.medics;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/medics")
public class MedicController {
  private final MedicService medicService;

  public MedicController(MedicService medicService) {
    this.medicService = medicService;
  }

  @GetMapping("/")
  ResponseEntity<?> index() {
    List<Medic> medics = medicService.index();
    return new ResponseEntity<>(medics, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  ResponseEntity<?> show(@PathVariable UUID id) throws NoSuchElementException {
    Medic medic = medicService.show(id);
    return new ResponseEntity<>(medic, HttpStatus.OK);
  }

  @PostMapping("/")
  ResponseEntity<?> store(@RequestBody @Valid MedicDTO medicDTO) throws IllegalArgumentException {
    Medic medic = medicService.store(medicDTO);
    return new ResponseEntity<>(medic, HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid MedicPatchDTO medicDTO)
      throws NoSuchElementException, IllegalArgumentException {
    Medic medic = medicService.update(medicDTO, id);
    return new ResponseEntity<>(medic, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<?> delete(@PathVariable UUID id) {
    medicService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}