package com.acn.masg.repository.setting;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.acn.masg.entity.setting.RevDuration;

public interface RevDurationRepo extends MongoRepository<RevDuration, ObjectId> {

}
