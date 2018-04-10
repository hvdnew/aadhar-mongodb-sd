package org.learn.mongodb.dataaccess;

import org.bson.types.ObjectId;
import org.learn.mongodb.data.master.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, ObjectId> {


}
