package com.eme.springTask.adapters;

import com.eme.springTask.entities.Owner;
import com.eme.springTask.entities.Pet;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PetAdapter extends Pet {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id",nullable = false)
    private Owner owner;


    public Pet getPet(){
        Pet pet = new Pet();
        pet.setId(this.getId());
        pet.setOwner(this.getOwner());
        pet.setDateOfBirth(this.getDateOfBirth());
        pet.setGender(this.getGender());
        pet.setKind(this.getKind());
        pet.setName(this.getName());
        pet.setWeight(this.getWeight());
        return pet;
    }
}
