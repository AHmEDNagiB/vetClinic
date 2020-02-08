package com.eme.springTask.repositories;

import com.eme.springTask.entities.Pet;
import com.eme.springTask.entities.Visit;
import org.springframework.data.repository.PagingAndSortingRepository;

/*
  PagingAndSortingRepository is used when we want paging and sorting function
*/

public interface VisitRepository extends PagingAndSortingRepository<Visit, Integer> {

}
