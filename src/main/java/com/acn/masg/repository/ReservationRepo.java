package com.acn.masg.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.acn.masg.entity.Reservation;

public interface ReservationRepo extends MongoRepository<Reservation, ObjectId> {
	List<Reservation> findByUid(String uid);
	
	// Rev Panel
	List<Reservation> findByRevMasgAndRevDateAndRevStatusOrderBySysDateDesc(String revMasg, String RevDate, byte revStatus);
	
	// Masg Rev List
	List<Reservation> findByRevMasgAndRevDateOrderByRevTime(String revMasg, String RevDate);
	
}
