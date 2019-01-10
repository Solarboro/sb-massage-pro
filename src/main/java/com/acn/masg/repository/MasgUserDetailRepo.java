package com.acn.masg.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.acn.masg.entity.MasgUserDetail;

public interface MasgUserDetailRepo extends MongoRepository<MasgUserDetail, ObjectId> {
	MasgUserDetail findByUsername(String username);
}
