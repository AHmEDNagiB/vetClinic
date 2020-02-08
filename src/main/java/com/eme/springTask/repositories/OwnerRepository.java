package com.eme.springTask.repositories;

import com.eme.springTask.entities.Owner;
import org.springframework.data.repository.PagingAndSortingRepository;


/*
  PagingAndSortingRepository is used when we want paging and sorting function
*/

public interface OwnerRepository extends PagingAndSortingRepository<Owner, Integer> {

}
