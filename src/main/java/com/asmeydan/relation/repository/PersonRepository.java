package com.asmeydan.relation.repository;

import com.asmeydan.relation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
