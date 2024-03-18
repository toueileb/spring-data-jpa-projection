package org.toueileb.springdatajpaprojection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<NamesOnly> findByLastname(String lastname);
    List<PersonSummary> findByFirstname(String firstname);
}
