package org.learn.mongodb.dataaccess;

import org.bson.types.ObjectId;
import org.learn.mongodb.data.link.document.LinkedBankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<LinkedBankAccount, ObjectId> {
}
