package com.acn.masg.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.acn.masg.entity.Reservation;

public interface ReservationRepo extends MongoRepository<Reservation, ObjectId> {

}
