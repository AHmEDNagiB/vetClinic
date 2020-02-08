package com.eme.springTask.services;

import com.eme.springTask.entities.Pet;
import com.eme.springTask.repositories.PetRepository;
import com.eme.springTask.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private PetRepository petRepository;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return (List<Pet>) petRepository.findAll();
    }

    public Pet getPetById(int petId) {
        return petRepository.findById(petId).orElse(null);
    }

    public long getPetsCont() {
        return petRepository.count();
    }


    public Pet addPet(Pet newPet) {
        System.out.println(newPet);
        Pet savedPet = null;
        try {
            savedPet = petRepository.save(newPet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedPet;
    }

}

