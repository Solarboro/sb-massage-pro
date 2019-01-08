package com.acn.masg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.entity.MasgUser;
import com.acn.masg.exception.MasgUserNotFoundException;
import com.acn.masg.repository.MasgUserRepo;

@RestController
@RequestMapping(value="/login")
public class LoginAPI {

	@Autowired
	private MasgUserRepo masgUserRepo;

	@RequestMapping(
			method=RequestMethod.POST,
			consumes="application/json")
	public MasgUser login(@RequestBody MasgUser masgUser) {
		MasgUser foMasgUser = this.masgUserRepo
								.findByUsernameAndPassword(
										masgUser.getUsername(), 
										masgUser.getPassword()
								);
		
		// 
		if (foMasgUser == null) {
			throw new MasgUserNotFoundException(masgUser);
		}
		
		return foMasgUser;
	}
}
