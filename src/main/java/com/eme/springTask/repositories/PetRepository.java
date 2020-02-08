package com.eme.springTask.repositories;

import com.eme.springTask.entities.Pet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
  PagingAndSortingRepository is used when we want paging and sorting function
*/

public interface PetRepository extends PagingAndSortingRepository<Pet, Integer> {

    List<Pet> findPetsByName(@Param("name") String name);

}
