package com.eme.springTask.controllers;

import com.eme.springTask.entities.Visit;
import com.eme.springTask.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/visit")
public class VisitController {

    private VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping(value = "/")
    public ResponseEntity getAllVisits() {
        List<Visit> visits = visitService.getAllVisits();
        return new ResponseEntity(visits, HttpStatus.OK);
    }

    @GetMapping(value = "/{visitId}")
    public ResponseEntity getFilmById(@PathVariable("visitId") int visitId) {
        Visit visit = visitService.getVisitById(visitId);
        if (visit != null) {
            return new ResponseEntity(visit, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PutMapping(value = "/")
    public ResponseEntity addVisit(@RequestBody Visit visit) {
        System.out.println(visit);
        Visit savedVisit = visitService.addUpdateVisit(visit);
        if (savedVisit != null) {
            return new ResponseEntity(savedVisit, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


}
