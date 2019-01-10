package com.acn.masg.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection="masguserdetail")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MasgUserDetail {
	
	private ObjectId _id;
	private String username;
	private String userGender;
	private String userDesc;
	private Integer curMthRevTimes;
	private boolean revBlocked;
	private String revBlockedDate;
	private String revReleaseDate;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public Integer getCurMthRevTimes() {
		return curMthRevTimes;
	}
	public void setCurMthRevTimes(Integer curMthRevTimes) {
		this.curMthRevTimes = curMthRevTimes;
	}
	public boolean isRevBlocked() {
		return revBlocked;
	}
	public void setRevBlocked(boolean revBlocked) {
		this.revBlocked = revBlocked;
	}
	public String getRevBlockedDate() {
		return revBlockedDate;
	}
	public void setRevBlockedDate(String revBlockedDate) {
		this.revBlockedDate = revBlockedDate;
	}
	public String getRevReleaseDate() {
		return revReleaseDate;
	}
	public void setRevReleaseDate(String revReleaseDate) {
		this.revReleaseDate = revReleaseDate;
	}
	
	
}
