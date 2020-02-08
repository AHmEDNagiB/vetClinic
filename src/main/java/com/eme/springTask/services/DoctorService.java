package com.eme.springTask.services;

import com.eme.springTask.entities.Doctor;
import com.eme.springTask.repositories.DoctorRepository;
import com.eme.springTask.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;
    @Autowired
    private FileUpload fileUpload;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }

    public long getDoctorsCont() {
        return doctorRepository.count();
    }


    public Doctor addUpdateDoctor(Doctor newDoctor) {
        System.out.println(newDoctor);
        Doctor savedDoctor = null;
        try {
            savedDoctor = doctorRepository.save(newDoctor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedDoctor;
    }


    public Doctor addDoctorWithPhoto(MultipartFile photo, String name, String phone) {
        Doctor doctor = new Doctor();
        doctor.setPhotoUrl(fileUpload.singleFileUpload(photo));
        doctor.setName(name);
        doctor.setPhone(phone);
        return addUpdateDoctor(doctor);
    }

}

