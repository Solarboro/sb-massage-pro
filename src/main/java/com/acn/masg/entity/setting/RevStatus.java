package com.acn.masg.entity.setting;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection="SettingRevStatus")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevStatus {
		
	private ObjectId _id;
	
	private Integer revStatus;
	private String revStatusDesc;
	private String revStatusCol;
	private boolean btnCommentRule;
	private boolean btnCancelRule;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public Integer getRevStatus() {
		return revStatus;
	}
	public void setRevStatus(Integer revStatus) {
		this.revStatus = revStatus;
	}
	public String getRevStatusDesc() {
		return revStatusDesc;
	}
	public void setRevStatusDesc(String revStatusDesc) {
		this.revStatusDesc = revStatusDesc;
	}
	public String getRevStatusCol() {
		return revStatusCol;
	}
	public void setRevStatusCol(String revStatusCol) {
		this.revStatusCol = revStatusCol;
	}
	public boolean isBtnCommentRule() {
		return btnCommentRule;
	}
	public void setBtnCommentRule(boolean btnCommentRule) {
		this.btnCommentRule = btnCommentRule;
	}
	public boolean isBtnCancelRule() {
		return btnCancelRule;
	}
	public void setBtnCancelRule(boolean btnCancelRule) {
		this.btnCancelRule = btnCancelRule;
	}
	

}
