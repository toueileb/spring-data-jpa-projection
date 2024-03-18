package org.toueileb.springdatajpaprojection;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataJpaProjectionApplication implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaProjectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var address1 = Address.builder()
                .city("City 1")
                .street("Street 1")
                .zipCode("zipCode 1")
                .build();

        var address2 = Address.builder()
                .city("City 2")
                .street("Street 2")
                .zipCode("zipCode 2")
                .build();


        var person1 = Person.builder()
                .firstname("Fistname1")
                .lastname("Lastname1")
                .address(address1)
                .build();

        var person2 = Person.builder()
                .firstname("Fistname1")
                .lastname("Lastname1")
                .address(address2)
                .build();

        addressRepository.saveAll(List.of(address1, address2));
        personRepository.saveAll(List.of(person1, person2));
    }
}
