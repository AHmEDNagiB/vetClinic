package com.eme.springTask.controllers;

import com.eme.springTask.entities.Clinic;
import com.eme.springTask.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clinic")
public class ClinicController {

    private ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping(value = "/")
    public ResponseEntity getAllClinics(
            @RequestParam(required = false, value = "phone") String phone,
            @RequestParam(required = false, value = "address") String address) {
        List<Clinic> clinics = clinicService.getAllClinics(phone, address);
        return new ResponseEntity(clinics, HttpStatus.OK);
    }

    @GetMapping(value = "/{clinicId}")
    public ResponseEntity getFilmById(@PathVariable("clinicId") int clinicId) {
        Clinic clinic = clinicService.getClinicById(clinicId);
        if (clinic != null) {
            return new ResponseEntity(clinic, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PostMapping(value = "/")
    public ResponseEntity addClinic(@RequestBody Clinic clinic) {
        System.out.println(clinic);
        Clinic savedClinic = clinicService.addClinic(clinic);
        if (savedClinic != null) {
            return new ResponseEntity(savedClinic, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


}
