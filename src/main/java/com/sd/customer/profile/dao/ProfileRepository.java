package com.sd.customer.profile.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.sd.customer.profile.model.CustomerProfile;

public interface ProfileRepository extends MongoRepository<CustomerProfile, ObjectId>{
	public CustomerProfile findByMobileNo(Long mobileNo);
}
