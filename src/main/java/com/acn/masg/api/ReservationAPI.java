package com.acn.masg.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.entity.MasgUser;
import com.acn.masg.entity.MasgUserDetail;
import com.acn.masg.entity.Reservation;
import com.acn.masg.entity.RevPanel;
import com.acn.masg.entity.RevPanelItem;
import com.acn.masg.repository.MasgUserDetailRepo;
import com.acn.masg.repository.MasgUserRepo;
import com.acn.masg.repository.ReservationRepo;
import com.acn.masg.util.SearchConditions;

@RestController
@RequestMapping(value="/rev")
public class ReservationAPI implements APIMaster<Reservation> {
	@Autowired
	private ReservationRepo reservationRepo;
	
	@Autowired
	private MasgUserDetailRepo masgUserDetailRepo;
	
	@Autowired
	private MasgUserRepo masgUserRepo;

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
		// TODO Should move to service;
		//  Set date
		entity.setSysDate(new Date());
		
		// update UserDetial
			MasgUserDetail masgUserDetail  = 
					this
					.masgUserDetailRepo
					.findByUsername(entity.getUid());
			Integer curMthRevTimes = masgUserDetail.getCurMthRevTimes();
			
			if(curMthRevTimes == null)
				curMthRevTimes = 1;
			else
				curMthRevTimes++;
			
			masgUserDetail.setCurMthRevTimes(curMthRevTimes);
			
			this.masgUserDetailRepo.save(masgUserDetail);
		
		
		return this.reservationRepo.save(entity);
	}

	@Override
	public void deleteEntity(Reservation entity) {
		this.reservationRepo.delete(entity);
	}
	
	@RequestMapping(value="/change/{status}",
			method=RequestMethod.POST,
			consumes="application/json")
	public Reservation cancelEntity(@RequestBody Reservation entity, @PathVariable byte status) {
		// TODO Should move to service;
		if (status == 5)
			entity.setRevComment(true);
		else
			entity.setRevStatus((byte) status);
		
		// clean no show
		if ( status == 2) {
			MasgUserDetail masgUserDetail  = 
					this
					.masgUserDetailRepo
					.findByUsername(entity.getUid());
			
			masgUserDetail.setRevBlocked(false);
			masgUserDetail.setRevBlockedDate("");
			masgUserDetail.setRevReleaseDate("");
			
			this.masgUserDetailRepo.save(masgUserDetail);
		}
		
		// no show
		if ( status == 3) {
			MasgUserDetail masgUserDetail  = 
					this
					.masgUserDetailRepo
					.findByUsername(entity.getUid());
			
			masgUserDetail.setRevBlocked(true);
			masgUserDetail.setRevBlockedDate("YYYY-MM");
			masgUserDetail.setRevReleaseDate("YYYY-(MM+2)");
			
			this.masgUserDetailRepo.save(masgUserDetail);
		}

		return this.reservationRepo.save(entity);
	}
	
	//
	
	@RequestMapping(value="/2masg",
			method=RequestMethod.GET,
			consumes="application/json")
	public List<Reservation> cancelEntity(@RequestParam String revMasg, String revDate) {

		return this
				.reservationRepo
				.findByRevMasgAndRevDateOrderByRevTime(revMasg, revDate);
	}
	
	//
	@RequestMapping(value="/revpanel")
	public RevPanel getRevPanel() {
		
		//
		RevPanel revPanel = new RevPanel();
		List<String> revMasgList = new ArrayList<String>();
		Map<String, RevPanelItem> revPanelItemMap = new HashMap<String, RevPanelItem>();
		
		//
		for(MasgUser masgUser: this.masgUserRepo.findByRole("masg")) {
			RevPanelItem revPanelItem = new RevPanelItem();
			String revMasg;
			List<String> revDateList = this.calDays();
			Map<String, Map<Integer, Reservation>> revDateDetailMap =
					new HashMap<String, Map<Integer,Reservation>>();
			
			//
			revMasg = masgUser.getUsername();
			revMasgList.add(revMasg);	
			for(String revDate: revDateList) {
				
				Map<Integer, Reservation> reservationMap = 
						new HashMap<Integer, Reservation>();
				for(Reservation reservation: 
					this.reservationRepo
					.findByRevMasgAndRevDateAndRevStatusOrderBySysDateDesc(revMasg, revDate, (byte)1))
				{
					//
					reservationMap.put(Integer.valueOf((int) reservation.getRevTime()), reservation);
				}
				//
				revDateDetailMap.put(revDate, reservationMap);
			}
			
			//
			revPanelItem.setRevMasg(revMasg);
			revPanelItem.setRevDateList(revDateList);
			revPanelItem.setRevDateDetailMap(revDateDetailMap);
			
			revPanelItemMap.put(revMasg, revPanelItem);
		}

		//		
		revPanel.setRevMasgList(revMasgList);
		revPanel.setRevPanelItemMap(revPanelItemMap);
		
		return revPanel;
	}
	
	private List<String> calDays() {
		List<String> revDateList = new ArrayList<String>();
		byte maxDays;
		
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		maxDays = 5;
		
		for(byte cnt = 1; cnt <= maxDays; cnt ++) {

			//
			calendar.add(Calendar.DATE, 1);
			
			//Sun Day, forward to Monday
			if (calendar.get(Calendar.DAY_OF_WEEK) == 1 )
				calendar.add(Calendar.DATE, 1);
			// Saturday, forward to Monday		
			if (calendar.get(Calendar.DAY_OF_WEEK) == 7 )
				calendar.add(Calendar.DATE, 2);
		
			
			revDateList.add(sdf.format(calendar.getTime()));
			
		}
		
		//		
		return revDateList;
	}

}
