package com.sd.customer.profile.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.customer.profile.dao.ProfileRepository;
import com.sd.customer.profile.model.CustomerProfile;
import org.springframework.hateoas.Resource;

@Service
public class ProfileService {
		
	@Autowired
	  private ProfileRepository profileRepository;
	

	public void insertDriverProfile(CustomerProfile profile){
		//generate id for this profile
		//profile.set_id(SDCommon.generateProfileId(profile.getMobileNo(), profile.getCountryCode()));
		profileRepository.insert(profile);
	}
	
	public Resource<CustomerProfile> findDriverProfile(ObjectId id){
		Optional<CustomerProfile> profile = profileRepository.findById(id);
//		if (!profile.isPresent())
//			throw new DriverNotFoundException("id-" + id);
		Resource<CustomerProfile> resource = new Resource<CustomerProfile>(profile.get());
		return resource;
	}
	
	public List<CustomerProfile> findAll(){
		return profileRepository.findAll();
	}
	
	public void updateDriverProfile(CustomerProfile updateProfile) {
//		Optional<Profile> profile = profileRepository.findById(updateProfile.get_id());
//		if (!profile.isPresent())
//			throw new DriverNotFoundException("id-" + updateProfile.get_id());
		profileRepository.save(updateProfile);
	}
	
	public void deleteById(ObjectId id) {
		profileRepository.deleteById(id);
	}
	
	public CustomerProfile findByMobileNo(Long mobileNo){
		return profileRepository.findByMobileNo(mobileNo);
	}
}
