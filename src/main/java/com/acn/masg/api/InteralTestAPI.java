package com.acn.masg.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.entity.InternalTest;
import com.acn.masg.repository.InternalTestRepo;

@RestController
@RequestMapping(value="/test")
public class InteralTestAPI implements APIMaster<InternalTest> {

	@Autowired
	private InternalTestRepo internalTestRepo;
	
	@RequestMapping(value="/one")
	public InternalTest postOne() {
		InternalTest entity = new InternalTest();
		entity.setMyDate(new Date());
		return this.internalTestRepo.save(entity);
	}
	
	@RequestMapping(value="/getone")
	public Date getone() {
		return new Date();
	}
	
	@RequestMapping(value="/saveone", method=RequestMethod.POST)
	public Date saveone(@RequestBody Date date) {
		InternalTest entity = new InternalTest();
		entity.setMyDate(date);
		
		return this.internalTestRepo.save(entity).getMyDate();
	}
	
	
	
	@Override
	public List<InternalTest> findAllEntity() {
		// TODO Auto-generated method stub
		return this.internalTestRepo.findAll();
	}

	@Override
	public List<InternalTest> findBySpeicfyId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalTest saveEntity(InternalTest entity) {
		return null;
	}

	@Override
	public void deleteEntity(InternalTest entity) {
		// TODO Auto-generated method stub
		
	}

}
