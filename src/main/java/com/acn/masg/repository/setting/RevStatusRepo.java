package com.acn.masg.repository.setting;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.acn.masg.entity.setting.RevStatus;

public interface RevStatusRepo extends MongoRepository<RevStatus, ObjectId> {

}
