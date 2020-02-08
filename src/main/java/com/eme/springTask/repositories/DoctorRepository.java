package com.eme.springTask.repositories;

import com.eme.springTask.entities.Doctor;
import org.springframework.data.repository.PagingAndSortingRepository;

/*
  PagingAndSortingRepository is used when we want paging and sorting function
*/

public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Integer> {



}
