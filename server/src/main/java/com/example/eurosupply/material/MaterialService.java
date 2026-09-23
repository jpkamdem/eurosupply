package com.example.eurosupply.material;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MaterialService {
  private final MaterialRepository materialRepository;

  public MaterialService(MaterialRepository materialRepository) {
    this.materialRepository = materialRepository;
  }

  public List<Material> index() {
    List<Material> materials = materialRepository.findAll();
    return materials;
  }

  public Material show(UUID id) throws NoSuchElementException {
    Material material = materialRepository.findById(id).orElseThrow();
    return material;
  }

  public Material store(MaterialDTO materialDTO) throws IllegalArgumentException {
    Material newMaterial = new Material();
    newMaterial.setName(materialDTO.getName());
    newMaterial.setQuantity(materialDTO.getQuantity());
    materialRepository.save(newMaterial);
    return newMaterial;
  }

  public Material update(MaterialPatchDTO materialDTO, UUID id)
      throws NoSuchElementException, IllegalArgumentException {
    Material foundMaterial = materialRepository.findById(id).orElseThrow();
    materialDTO.getName().ifPresent(foundMaterial::setName);
    materialDTO.getQuantity().ifPresent(foundMaterial::setQuantity);
    materialRepository.save(foundMaterial);
    return foundMaterial;
  }

  public void delete(UUID id) {
    materialRepository.deleteById(id);
  }
}