package com.acn.masg.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.entity.MasgUserDetail;
import com.acn.masg.repository.MasgUserDetailRepo;

@RestController
@RequestMapping(value="/masguser/detail")
public class MasgUserDetailApi implements APIMaster<MasgUserDetail> {
	
	@Autowired
	private MasgUserDetailRepo masgUserDetailRepo;

	@Override
	public List<MasgUserDetail> findAllEntity() {
		return this.masgUserDetailRepo.findAll();
	}

	@Override
	public List<MasgUserDetail> findBySpeicfyId(String id) {
		return null;
	}

	@Override
	public MasgUserDetail saveEntity(MasgUserDetail entity) {
		return this.masgUserDetailRepo.save(entity);
	}

	@Override
	public void deleteEntity(MasgUserDetail entity) {
		this.masgUserDetailRepo.delete(entity);
	}
	
	@RequestMapping(value="/specify/{username}", method=RequestMethod.GET)
	public MasgUserDetail saveEntity(@PathVariable String username) {
		return this.masgUserDetailRepo.findByUsername(username);
	}

}
