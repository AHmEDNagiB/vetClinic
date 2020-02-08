package com.eme.springTask.services;

import com.eme.springTask.entities.Clinic;
import com.eme.springTask.repositories.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {
    private ClinicRepository clinicRepository;

    @Autowired
    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public List<Clinic> getAllClinics(String phone, String address) {
        if (phone != null && address != null) {
            return (List<Clinic>) clinicRepository.findClinicByPhoneContainingOrAddressContaining(phone, address);

        } else if (address != null) {
            return (List<Clinic>) clinicRepository.findClinicByAddressContaining(address);

        } else if (phone != null) {

            return (List<Clinic>) clinicRepository.findClinicsByPhoneContaining(phone);
        } else {
            return (List<Clinic>) clinicRepository.findAll();

        }
    }

    public Clinic getClinicById(int ClinicId) {
        return clinicRepository.findById(ClinicId).orElse(null);
    }

    public long getClinicsCont() {
        return clinicRepository.count();
    }


    public Clinic addClinic(Clinic newClinic) {
        System.out.println(newClinic);
        Clinic savedClinic = null;
        try {
            savedClinic = clinicRepository.save(newClinic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedClinic;
    }

}

