package com.acn.masg.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection="reservation")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reservation {
	
	private ObjectId _id;
	
	private String uid;
	private String revMasg;
	private byte revStatus;
	private boolean revComment;
	private byte revTime;
	private String revDate;
	private String revFloor;
	private String revBuilding;
	
	private Date sysDate;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRevMasg() {
		return revMasg;
	}

	public void setRevMasg(String revMasg) {
		this.revMasg = revMasg;
	}

	public byte getRevStatus() {
		return revStatus;
	}

	public void setRevStatus(byte revStatus) {
		this.revStatus = revStatus;
	}

	public boolean isRevComment() {
		return revComment;
	}

	public void setRevComment(boolean revComment) {
		this.revComment = revComment;
	}

	public byte getRevTime() {
		return revTime;
	}

	public void setRevTime(byte revTime) {
		this.revTime = revTime;
	}

	public String getRevDate() {
		return revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}

	public String getRevFloor() {
		return revFloor;
	}

	public void setRevFloor(String revFloor) {
		this.revFloor = revFloor;
	}

	public String getRevBuilding() {
		return revBuilding;
	}

	public void setRevBuilding(String revBuilding) {
		this.revBuilding = revBuilding;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}
	
	
}
