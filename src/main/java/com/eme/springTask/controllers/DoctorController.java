package com.eme.springTask.controllers;

import com.eme.springTask.entities.Doctor;
import com.eme.springTask.services.DoctorService;
import com.eme.springTask.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(value = "/")
    public ResponseEntity getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity(doctors, HttpStatus.OK);
    }

    @GetMapping(value = "/{doctorId}")
    public ResponseEntity getFilmById(@PathVariable("doctorId") int doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (doctor != null) {
            return new ResponseEntity(doctor, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PostMapping(value = "/")
    public ResponseEntity addDoctor(@RequestBody Doctor doctor) {
        System.out.println(doctor);
        Doctor savedDoctor = doctorService.addUpdateDoctor(doctor);
        if (savedDoctor != null) {
            return new ResponseEntity(savedDoctor, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/")
    public ResponseEntity updateDoctor(@RequestBody Doctor doctor) {
        System.out.println(doctor);
        Doctor savedDoctor = doctorService.addUpdateDoctor(doctor);
        if (savedDoctor != null) {
            return new ResponseEntity(savedDoctor, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/doctorwithphotofile")
    public ResponseEntity addDoctorWithPhotoFile(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone
    ) {

        Doctor savedDoctor = doctorService.addDoctorWithPhoto(photo , name , phone);
        if (savedDoctor != null) {
            return new ResponseEntity(savedDoctor, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


}
