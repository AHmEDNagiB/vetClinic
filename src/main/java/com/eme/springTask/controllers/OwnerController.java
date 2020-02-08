package com.eme.springTask.controllers;

import com.eme.springTask.entities.Owner;
import com.eme.springTask.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/owner")
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(value = "/")
    public ResponseEntity getAllOwners() {
        List<Owner> ownerList = ownerService.getAllOwners();
        return new ResponseEntity(ownerList, HttpStatus.OK);
    }

    @GetMapping(value = "/{ownerId}")
    public ResponseEntity getOwnerById(@PathVariable("ownerId") int ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        if (owner != null) {
            return new ResponseEntity(owner, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
    @GetMapping(value = "/{ownerId}/pets")
    public ResponseEntity getPetsByOwnerId(@PathVariable("ownerId") int ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        if (owner != null) {
            return new ResponseEntity(owner.getPetsList(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PostMapping(value = "/")
    public ResponseEntity addOwner(@RequestBody Owner owner){
    Owner savedOwner = ownerService.addOwner(owner);
        if (savedOwner != null) {
            return new ResponseEntity(savedOwner, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
