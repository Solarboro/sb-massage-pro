package com.acn.masg.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.acn.masg.entity.MasgUser;

public interface MasgUserRepo extends MongoRepository<MasgUser, ObjectId> {
	MasgUser findByUsernameAndPassword(String username, String password);
	MasgUser findByUsername(String username);
}
