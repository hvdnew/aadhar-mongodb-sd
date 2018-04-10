package org.learn.mongodb;

import org.learn.mongodb.data.link.document.LinkedBankAccount;
import org.learn.mongodb.data.link.document.LinkedDocument;
import org.learn.mongodb.data.link.document.LinkedDocumentHolder;
import org.learn.mongodb.data.link.document.LinkedPANCard;
import org.learn.mongodb.data.link.txn.LinkedTransaction;
import org.learn.mongodb.data.link.txn.LinkedTransactionHolder;
import org.learn.mongodb.data.master.Address;
import org.learn.mongodb.data.master.AddressHolder;
import org.learn.mongodb.data.master.Person;
import org.learn.mongodb.data.master.VerificationStatus;
import org.learn.mongodb.dataaccess.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Component
public class PersistenceApplication implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PersonRepository personRepository;

    private final Logger log = Logger.getLogger(PersistenceApplication.class.getName());


    @Override
    public void run(String... args) throws Exception {

        insertBulk();
    }

    private void insertBulk() {

        for (int i = 0; i < 2000; i++) {

            final String aadhaarNumber = "harsh" + i;

            insertOne(aadhaarNumber);

            if (i % 5 == 0) {
                accessAndUpdateVerificationInfo(aadhaarNumber);
            }

            if (i % 13 == 0) {
                accessAndUpdateTransactionInfo(aadhaarNumber);
            }
        }

    }


    private void accessAndUpdateTransactionInfo(String aadharNumber) {

        Person person = personRepository.findByAadhaarNumber(aadharNumber);

        if (person != null) {

            List<LinkedTransaction> transactions = new ArrayList<>(0);

            Random random = new Random();

            int randomTxns = random.nextInt(10) + 1;
            LinkedTransaction linkedTransaction;

            for (int i = 0; i < randomTxns; i++) {
                linkedTransaction = new LinkedTransaction("21312c2121312d31", BigDecimal.TEN, new Date(), LinkedTransaction.TransactionMode.ONLINE);
                linkedTransaction.setBankAccount((LinkedBankAccount) person.getBankAccount().getDocument());
                transactions.add(linkedTransaction);
                mongoTemplate.save(linkedTransaction);

            }

            person.setTxnHolder(new LinkedTransactionHolder(transactions));
            mongoTemplate.save(person);

        }


    }


    private void accessAndUpdateVerificationInfo(String aadharNumber) {

        Person person = personRepository.findByAadhaarNumber(aadharNumber);

        if (person != null) {

            person.setMobile(new Person.Phone(Person.PhoneType.MOBILE, "mymobilenumber"));
            person.getBankAccount().getStatus().setVerified(true);

            LinkedBankAccount bankDoc = (LinkedBankAccount) person.getBankAccount().getDocument();
            bankDoc.setLinkedDate(new Date());
            bankDoc.setBankType("SBI BANK");

            Address address = person.getAddress().getAddress();
            address.setPinCode("333024");

            mongoTemplate.save(address);
            mongoTemplate.save(bankDoc);
            mongoTemplate.save(person);

        }


    }


    private void insertOne(String aadharNumber) {

        Person person = new Person(aadharNumber, "Mr" + aadharNumber, "Anderson", Person.Gender.MALE, Date.from(Instant.now()));
        person.setEmail("hvdnew@gmail.com");

        Address address = new Address("K5-16 First Floor" + aadharNumber, "Sector 5", null, "Gurugram", "Haryana", "122333");
        person.setAddress(new AddressHolder(address, new VerificationStatus(true, LinkedDocument.LinkedDocumentType.DL)));

        LinkedPANCard pan = new LinkedPANCard("####", person.getAadhaarNumber(), person.getFirstName(), person.getLastName(), new Date("16/05/1991"));
        person.setPanCard(new LinkedDocumentHolder(pan, new VerificationStatus(false, LinkedDocument.LinkedDocumentType.PAN_CARD)));

        LinkedBankAccount bankAccount = new LinkedBankAccount("34232323332" + aadharNumber, "CITY", person.getAadhaarNumber(), person.getFirstName(), person.getLastName(), "IFSC0000FFD", new Date());
        person.setBankAccount(new LinkedDocumentHolder(bankAccount, new VerificationStatus(false, LinkedDocument.LinkedDocumentType.BANK)));

        mongoTemplate.save(address);
        mongoTemplate.save(pan);
        mongoTemplate.save(bankAccount);
        mongoTemplate.save(person);
    }

}
