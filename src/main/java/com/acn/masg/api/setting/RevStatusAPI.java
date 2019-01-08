package com.acn.masg.api.setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.api.APIMaster;
import com.acn.masg.entity.setting.RevStatus;
import com.acn.masg.repository.setting.RevStatusRepo;

@RestController
@RequestMapping(value="/setting/revstatus/")
public class RevStatusAPI implements APIMaster<RevStatus> {

	@Autowired
	private RevStatusRepo revStatusRepo;

	@Override
	public List<RevStatus> findAllEntity() {
		return this.revStatusRepo.findAll();
	}

	@Override
	public List<RevStatus> findBySpeicfyId(String id) {
		return null;
	}

	@Override
	public RevStatus saveEntity(RevStatus entity) {
		return this.revStatusRepo.save(entity);
	}

	@Override
	public void deleteEntity(RevStatus entity) {
		this.revStatusRepo.delete(entity);
	}

}
