package org.studyeasy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.studyeasy.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
