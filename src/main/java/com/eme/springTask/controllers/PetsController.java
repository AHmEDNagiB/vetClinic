package com.eme.springTask.controllers;

import com.eme.springTask.adapters.PetAdapter;
import com.eme.springTask.entities.Pet;
import com.eme.springTask.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pet")
public class PetsController {

    private PetService petService;

    @Autowired
    public PetsController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(value = "/")
    public ResponseEntity getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return new ResponseEntity(pets, HttpStatus.OK);
    }

    @GetMapping(value = "/{petId}")
    public ResponseEntity getFilmById(@PathVariable("petId") int petId) {
        Pet pet = petService.getPetById(petId);
        if (pet != null) {
            return new ResponseEntity(pet, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PostMapping(value = "/")
    public ResponseEntity addPet(@RequestBody PetAdapter pet) {
        System.out.println(pet.getPet());
        Pet savedPet = petService.addPet(pet.getPet());
        if (savedPet != null) {
            return new ResponseEntity(savedPet, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


}
