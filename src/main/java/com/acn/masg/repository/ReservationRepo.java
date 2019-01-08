package com.acn.masg.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.acn.masg.entity.Reservation;

public interface ReservationRepo extends MongoRepository<Reservation, ObjectId> {
	List<Reservation> findByUid(String uid);
}
