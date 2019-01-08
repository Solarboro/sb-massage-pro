package com.acn.masg.api.setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.api.APIMaster;
import com.acn.masg.entity.setting.RevDuration;
import com.acn.masg.repository.setting.RevDurationRepo;

@RestController
@RequestMapping(value="/setting/revduration/")
public class RevDurationAPI implements APIMaster<RevDuration> {

	@Autowired
	private RevDurationRepo revDurationRepo;
	
	@Override
	public List<RevDuration> findAllEntity() {
		return this.revDurationRepo.findAll();
	}

	@Override
	public List<RevDuration> findBySpeicfyId(String id) {
		return null;
	}

	@Override
	public RevDuration saveEntity(RevDuration entity) {
		return this.revDurationRepo.save(entity);
	}

	@Override
	public void deleteEntity(RevDuration entity) {
		this.revDurationRepo.delete(entity);
	}

}
