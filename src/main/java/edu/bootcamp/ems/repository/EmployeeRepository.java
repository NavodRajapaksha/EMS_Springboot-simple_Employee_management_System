package edu.bootcamp.ems.repository;

import edu.bootcamp.ems.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByEmail(String email);
}
