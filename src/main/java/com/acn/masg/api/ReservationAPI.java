package com.acn.masg.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.entity.Reservation;
import com.acn.masg.repository.ReservationRepo;

@RestController
@RequestMapping(value="/rev")
public class ReservationAPI implements APIMaster<Reservation> {
	@Autowired
	private ReservationRepo reservationRepo;

	@Override
	public List<Reservation> findAllEntity() {
		return this.reservationRepo.findAll();
	}

	@Override
	public List<Reservation> findBySpeicfyId(String id) {
		return this.reservationRepo.findByUid(id);
	}

	@Override
	public Reservation saveEntity(Reservation entity) {
		return this.reservationRepo.save(entity);
	}

	@Override
	public void deleteEntity(Reservation entity) {
		this.reservationRepo.delete(entity);
	}

}
