package com.acn.masg.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.acn.masg.entity.MasgUser;

public interface MasgUserRepo extends MongoRepository<MasgUser, ObjectId> {
	MasgUser findByUsernameAndPassword(String username, String password);
	MasgUser findByUsername(String username);
	
	//
	List<MasgUser> findByRole(String role);
}
