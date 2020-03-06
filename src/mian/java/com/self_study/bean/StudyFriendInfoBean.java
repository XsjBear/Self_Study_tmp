package com.self_study.bean;

import java.io.Serializable;

public class StudyFriendInfoBean implements Serializable{
	
	private String id;
	private String userid;
	private String nickname;
	private String targetcontent;
	private String current_state;
	private String target_description;
	public StudyFriendInfoBean(String id, String userid, String nickname, String targetcontent, String current_state,
			String target_description) {
		super();
		this.id = id;
		this.userid = userid;
		this.nickname = nickname;
		this.targetcontent = targetcontent;
		this.current_state = current_state;
		this.target_description = target_description;
	}
	public StudyFriendInfoBean() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTargetcontent() {
		return targetcontent;
	}
	public void setTargetcontent(String targetcontent) {
		this.targetcontent = targetcontent;
	}
	public String getCurrent_state() {
		return current_state;
	}
	public void setCurrent_state(String current_state) {
		this.current_state = current_state;
	}
	public String getTarget_description() {
		return target_description;
	}
	public void setTarget_description(String target_description) {
		this.target_description = target_description;
	}
	@Override
	public String toString() {
		return "StudyFriendInfoBean [id=" + id + ", userid=" + userid + ", nickname=" + nickname + ", targetcontent="
				+ targetcontent + ", current_state=" + current_state + ", target_description=" + target_description
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((current_state == null) ? 0 : current_state.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((target_description == null) ? 0 : target_description.hashCode());
		result = prime * result + ((targetcontent == null) ? 0 : targetcontent.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudyFriendInfoBean other = (StudyFriendInfoBean) obj;
		if (current_state == null) {
			if (other.current_state != null)
				return false;
		} else if (!current_state.equals(other.current_state))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (target_description == null) {
			if (other.target_description != null)
				return false;
		} else if (!target_description.equals(other.target_description))
			return false;
		if (targetcontent == null) {
			if (other.targetcontent != null)
				return false;
		} else if (!targetcontent.equals(other.targetcontent))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	
}
