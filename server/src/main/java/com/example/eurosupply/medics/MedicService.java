package com.example.eurosupply.medics;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MedicService {
  private final MedicRepository medicRepository;

  public MedicService(MedicRepository medicRepository) {
    this.medicRepository = medicRepository;
  }

  List<Medic> index() {
    List<Medic> medics = medicRepository.findAll();
    return medics;
  }

  Medic show(UUID id) throws NoSuchElementException {
    Medic medic = medicRepository.findById(id).orElseThrow();
    return medic;
  }

  Medic store(MedicDTO newMedic) throws IllegalArgumentException {
    Medic medic = new Medic();
    medic.setName(newMedic.getName());
    medic.setQuantity(newMedic.getQuantity());
    medicRepository.save(medic);
    return medic;
  }

  Medic update(MedicPatchDTO medicDTO, UUID id) throws NoSuchElementException, IllegalArgumentException {
    Medic foundMedic = medicRepository.findById(id).orElseThrow();
    medicDTO.getName().ifPresent(foundMedic::setName);
    medicDTO.getQuantity().ifPresent(foundMedic::setQuantity);
    medicRepository.save(foundMedic);
    return foundMedic;
  }

  void delete(UUID id) {
    medicRepository.deleteById(id);
  }
}