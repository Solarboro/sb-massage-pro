package com.acn.masg.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.entity.Reservation;
import com.acn.masg.repository.ReservationRepo;

@RestController
@RequestMapping(value="/rev")
public class ReservationAPI {
	@Autowired
	private ReservationRepo reservationRepo;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String revList() {
		return "This is revList Link";
	}
	
	@RequestMapping(value="/save",
			method=RequestMethod.POST,
			consumes="application/json")
	public Reservation revSave(@RequestBody Reservation rev) {
//		Reservation rev = new Reservation();
//		
//		rev.setRevBuilding("XY");
//		rev.setRevComment(false);
//		rev.setRevDate("2018.12.12");
//		rev.setRevFloor("13");
//		rev.setRevMasg("Kerry");
//		rev.setRevStatus((byte)1);
//		rev.setRevTime((byte)1);
//		rev.setUid(uid);
//		
		return this.reservationRepo.save(rev);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String revDelete() {
		
		return "This is revDelete Link";
	}

	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public List<Reservation> revFind() {
		
		return reservationRepo.findAll();
	}


}
