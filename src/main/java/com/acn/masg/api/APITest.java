package com.acn.masg.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.entity.setting.RevDuration;
import com.acn.masg.entity.setting.RevStatus;
import com.acn.masg.repository.setting.RevDurationRepo;
import com.acn.masg.repository.setting.RevStatusRepo;

@RestController
@RequestMapping(value="/setting/map/")
public class APITest {
	
	@Autowired
	private RevStatusRepo revStatusRepo;
	
	@Autowired
	private RevDurationRepo revDurationRepo;
	
	@RequestMapping(value="/revstatus")
	public Map<Integer, RevStatus> getRevStatusMap(){
		Map<Integer, RevStatus> localMap = new HashMap<Integer, RevStatus>();
		
		for( RevStatus rev: this.revStatusRepo.findAll()) {
			localMap.put(rev.getRevStatus(), rev);
		}		
		
		return localMap;
	
	}
	
	//
	@RequestMapping(value="/revduration")
	public Map<Integer, RevDuration> getRevDurationMap(){
		Map<Integer, RevDuration> localMap = new HashMap<Integer, RevDuration>();
		
		for( RevDuration rev: this.revDurationRepo.findAll()) {
			localMap.put(rev.getRevTime(), rev);
		}		
		
		return localMap;
	
	}


}
