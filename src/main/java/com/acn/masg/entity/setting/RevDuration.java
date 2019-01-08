package com.acn.masg.entity.setting;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection="SettingRevDuration")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevDuration {
	
	private ObjectId _id;
	
	private Integer revTime;
	private String revTimeDesc;
	private String revMeridiem;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public Integer getRevTime() {
		return revTime;
	}
	public void setRevTime(Integer revTime) {
		this.revTime = revTime;
	}
	public String getRevTimeDesc() {
		return revTimeDesc;
	}
	public void setRevTimeDesc(String revTimeDesc) {
		this.revTimeDesc = revTimeDesc;
	}
	public String getRevMeridiem() {
		return revMeridiem;
	}
	public void setRevMeridiem(String revMeridiem) {
		this.revMeridiem = revMeridiem;
	}
	
	

}
