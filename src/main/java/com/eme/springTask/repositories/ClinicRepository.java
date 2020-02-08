package com.eme.springTask.repositories;

import com.eme.springTask.entities.Clinic;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
  PagingAndSortingRepository is used when we want paging and sorting function
*/

public interface ClinicRepository extends PagingAndSortingRepository<Clinic, Integer> {

    List<Clinic> findClinicByPhoneContainingOrAddressContaining(@Param("phone") String phone, @Param("address") String address);

    List<Clinic> findClinicByAddressContaining(@Param("address") String address);

    List<Clinic> findClinicsByPhoneContaining(@Param("phone") String phone);

}
