package com.eme.springTask.services;

import com.eme.springTask.entities.Owner;
import com.eme.springTask.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    public List<Owner> getAllOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    public Owner getOwnerById(int ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    public Owner addOwner(Owner newOwner) {
        Owner savedOwner = null;
        try {
            System.out.println(newOwner);
            savedOwner = ownerRepository.save(newOwner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedOwner;
    }

}
