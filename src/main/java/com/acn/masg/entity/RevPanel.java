package com.acn.masg.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevPanel {

	private List<String> revMasgList;
		
	private Map<String, RevPanelItem> revPanelItemMap;

	public List<String> getRevMasgList() {
		return revMasgList;
	}

	public void setRevMasgList(List<String> revMasgList) {
		this.revMasgList = revMasgList;
	}

	public Map<String, RevPanelItem> getRevPanelItemMap() {
		return revPanelItemMap;
	}

	public void setRevPanelItemMap(Map<String, RevPanelItem> revPanelItemMap) {
		this.revPanelItemMap = revPanelItemMap;
	}	
}
