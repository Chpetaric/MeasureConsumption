package org.studyeasy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.studyeasy.entity.Address;


@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}