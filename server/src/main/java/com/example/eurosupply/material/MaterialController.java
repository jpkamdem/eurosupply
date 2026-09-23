package com.example.eurosupply.material;

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
@RequestMapping("/api/materials")
public class MaterialController {
  private final MaterialService materialService;

  public MaterialController(MaterialService materialService) {
    this.materialService = materialService;
  }

  @GetMapping("/")
  ResponseEntity<?> index() {
    List<Material> materials = materialService.index();
    return new ResponseEntity<>(materials, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  ResponseEntity<?> show(@PathVariable UUID id) throws NoSuchElementException {
    Material material = materialService.show(id);
    return new ResponseEntity<>(material, HttpStatus.OK);
  }

  @PostMapping("/")
  ResponseEntity<?> store(@RequestBody @Valid MaterialDTO materialDTO) {
    Material newMaterial = materialService.store(materialDTO);
    return new ResponseEntity<>(newMaterial, HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid MaterialPatchDTO materialDTO)
      throws NoSuchElementException, IllegalArgumentException {
    Material material = materialService.update(materialDTO, id);
    return new ResponseEntity<>(material, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<?> delete(@PathVariable UUID id) throws NoSuchElementException {
    materialService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}