package com.sd.customer.profile.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Resource;
import com.sd.customer.profile.model.CustomerProfile;
import com.sd.customer.profile.service.ProfileService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/drivers/")
public class ProfileController {	
	@Autowired
	private  ProfileService profileService;
	
	@ApiOperation(value = "Find a driver by id",
		    notes = "Also returns a link to retrieve all drivers with rel - all-drivers")
	@GetMapping(value = "profile/{id}", produces = "application/json")
	public Resource<CustomerProfile> getDriverInfo(@PathVariable ObjectId id){
		return profileService.findDriverProfile(id);
	}
	
	@GetMapping(value="profile", produces="application/json")
	public List<CustomerProfile> findAll(){
		return profileService.findAll();
	}
	
	@PostMapping("profile")
	public void insertDriverInfo(@RequestBody CustomerProfile driverProfile){
		profileService.insertDriverProfile(driverProfile);
	}
	
	@PutMapping("profile/{id}")
	public void updateStudent(@RequestBody CustomerProfile profile, @PathVariable String id) {
		//return ResponseEntity.noContent().build();
		profileService.updateDriverProfile(profile);
	}

	@DeleteMapping("profile/{id}")
	public void delete(@PathVariable String id) {
		profileService.deleteById(new ObjectId(id));
	}

	@GetMapping(value="profile/mobile/{mobile}", produces="application/json")
	public CustomerProfile getProfileByMobileNo(@PathVariable Long mobile){
		return profileService.findByMobileNo(mobile);
	}
	
}
