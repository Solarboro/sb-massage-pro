package com.acn.masg.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.entity.MasgUser;
import com.acn.masg.repository.MasgUserRepo;

@RestController
@RequestMapping(value="/masguser")
public class MasgUserAPI implements APIMaster<MasgUser> {

	@Autowired
	private MasgUserRepo masgUserRepo;
	
	@Override
	public List<MasgUser> findAllEntity() {
		return this.masgUserRepo.findAll();
	}

	@Override
	public List<MasgUser> findBySpeicfyId(String id) {
		return null;
	}

	@Override
	public MasgUser saveEntity(MasgUser entity) {
		return this.masgUserRepo.save(entity);
	}

	@Override
	public void deleteEntity(MasgUser entity) {
		this.masgUserRepo.delete(entity);
	}

}
