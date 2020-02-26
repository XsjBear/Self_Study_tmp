package com.self_study.bean;

import java.io.Serializable;

/**
 * Friend表实体对象
 * @author Xsj
 *
 */
public class FriendBean implements Serializable{
	
	private int id;
	private int userid;
	private int targetid;
	private String current_state;
	private String target_description;
	
	
	public FriendBean(int id, int userid, int targetid, String current_state, String target_description) {
		super();
		this.id = id;
		this.userid = userid;
		this.targetid = targetid;
		this.current_state = current_state;
		this.target_description = target_description;
	}
	
	public FriendBean() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getTargetid() {
		return targetid;
	}

	public void setTargetid(int targetid) {
		this.targetid = targetid;
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
		return "FriendBean [id=" + id + ", userid=" + userid + ", targetid=" + targetid + ", current_state="
				+ current_state + ", target_description=" + target_description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((current_state == null) ? 0 : current_state.hashCode());
		result = prime * result + id;
		result = prime * result + ((target_description == null) ? 0 : target_description.hashCode());
		result = prime * result + targetid;
		result = prime * result + userid;
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
		FriendBean other = (FriendBean) obj;
		if (current_state == null) {
			if (other.current_state != null)
				return false;
		} else if (!current_state.equals(other.current_state))
			return false;
		if (id != other.id)
			return false;
		if (target_description == null) {
			if (other.target_description != null)
				return false;
		} else if (!target_description.equals(other.target_description))
			return false;
		if (targetid != other.targetid)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

}
