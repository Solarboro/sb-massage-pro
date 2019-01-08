package com.acn.masg.exception;

import com.acn.masg.entity.MasgUser;

public class MasgUserNotFoundException extends RuntimeException {

	private MasgUser masgUser;

	public MasgUserNotFoundException(MasgUser masgUser) {
		this.masgUser = masgUser;
	}

	public MasgUser getMasgUser() {
		return masgUser;
	}

	public void setMasgUser(MasgUser masgUser) {
		this.masgUser = masgUser;
	}
	
	
	
}
