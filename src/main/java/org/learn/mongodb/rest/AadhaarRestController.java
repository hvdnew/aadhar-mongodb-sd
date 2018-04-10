package org.learn.mongodb.rest;

import org.learn.mongodb.data.master.Person;
import org.learn.mongodb.dataaccess.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(produces = "application/json")
public class AadhaarRestController {

    @Autowired
    private PersonRepository personRepository;

    /**
     * <p>Simple search</p>
     *
     * @param aadhaarNumber
     * @return
     */
    @GetMapping(value = "/person")
    public Person getPersonByAadhaarNumber(@Param("aadhaarNumber") String aadhaarNumber) {

        Person person = personRepository.findByAadhaarNumber(aadhaarNumber);

        return person;
    }

    /**
     * <p>Search using example</p>
     *
     * @param email
     * @param lastName
     * @param pageNumber
     * @return
     */
    @GetMapping("/person-search")
    public Page<Person> findMatching(@Param("email") String email, @Param("lastName") String lastName, @Param("pageNumber") int pageNumber) {

        Person example = new Person();
        example.setEmail(email);
        example.setLastName(lastName);

        Example<Person> example1 = Example.of(example);

        return personRepository.findAll(example1, new PageRequest(pageNumber, 5));
    }

    /**
     * <p>people with bank link information</p>
     *
     * @param status
     * @return
     */
    @GetMapping("/person-search-bank")
    List<Person> findByBankVerificationStatus(@Param("status") boolean status) {

        return personRepository.findPeopleWithBankStatus(status);
    }


    /**
     * <p>people in trouble</p>
     *
     * @param noOfTxn
     * @return
     */
    @GetMapping("/person-search-it")
    List<Person> findPeopleUnderITRadar(@Param("noOfTxn") int noOfTxn) {
        return personRepository.findPeopleWithGTENLinkedTxn(noOfTxn);
    }


}
