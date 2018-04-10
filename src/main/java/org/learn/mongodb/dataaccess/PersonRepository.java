package org.learn.mongodb.dataaccess;

import org.learn.mongodb.data.master.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByAadhaarNumber(String aadhaarNumber);

    @Query(value = "{'bankAccount.status.verified': ?0}", fields = "{firstName: 1, lastName: 1, aadhaarNumber: 1}")
    List<Person> findPeopleWithBankStatus(boolean verificationStatus);

    @Query(value = "{'txnHolder.count': {$gte: ?0}, 'bankAccount.status.verified': true }", fields = "{firstName: 1, lastName: 1, aadhaarNumber: 1}")
    List<Person> findPeopleWithGTENLinkedTxn(int noOfTxn);
}
