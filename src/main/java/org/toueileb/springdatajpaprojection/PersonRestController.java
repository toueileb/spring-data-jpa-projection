package org.toueileb.springdatajpaprojection;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class PersonRestController {
    private final PersonRepository personRepository;

    @GetMapping("person/namesOnly/{lastname}")
    public List<NamesOnly> getAll(@PathVariable("lastname") String lastname){
        return personRepository.findByLastname(lastname);
    }

    @GetMapping("person/PersonSummary/{firstname}")
    public List<PersonSummary> getAllPersonSummary(@PathVariable("firstname") String firstname){
        return personRepository.findByFirstname(firstname);
    }
}
