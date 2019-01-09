package com.acn.masg.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevPanelItem {
	
	private String revMasg;
	
	private List<String> revDateList;
	
	private Map<String, Map<Integer, Reservation>> revDateDetailMap;

	public String getRevMasg() {
		return revMasg;
	}

	public void setRevMasg(String revMasg) {
		this.revMasg = revMasg;
	}

	public List<String> getRevDateList() {
		return revDateList;
	}

	public void setRevDateList(List<String> revDateList) {
		this.revDateList = revDateList;
	}

	public Map<String, Map<Integer, Reservation>> getRevDateDetailMap() {
		return revDateDetailMap;
	}

	public void setRevDateDetailMap(Map<String, Map<Integer, Reservation>> revDateDetailMap) {
		this.revDateDetailMap = revDateDetailMap;
	}


}
