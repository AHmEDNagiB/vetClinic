package com.eme.springTask.services;

import com.eme.springTask.entities.Visit;
import com.eme.springTask.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {
    private VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> getAllVisits() {
            return (List<Visit>) visitRepository.findAll();
    }

    public Visit getVisitById(int visitId) {
        return visitRepository.findById(visitId).orElse(null);
    }

    public long getVisitsCont() {
        return visitRepository.count();
    }


    public Visit addUpdateVisit(Visit newVisit) {
        System.out.println(newVisit);
        Visit savedVisit = null;
        try {
            savedVisit = visitRepository.save(newVisit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedVisit;
    }



}

