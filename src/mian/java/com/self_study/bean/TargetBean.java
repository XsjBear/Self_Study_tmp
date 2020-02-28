package com.self_study.bean;

import java.io.Serializable;

/**
 * Target表Bena
 * @author Xsj
 *
 */
public class TargetBean implements Serializable{
	
	private String targetid;	//目标id
	private String targetcontent;	//目标内容
	private String state;	//目标状态
	
	public TargetBean(String targetid, String targetcontent, String state) {
		super();
		this.targetid = targetid;
		this.targetcontent = targetcontent;
		this.state = state;
	}

	public TargetBean() {
		super();
	}

	public String getTargetid() {
		return targetid;
	}

	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}

	public String getTargetcontent() {
		return targetcontent;
	}

	public void setTargetcontent(String targetcontent) {
		this.targetcontent = targetcontent;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "TargetBean [targetid=" + targetid + ", targetcontent=" + targetcontent + ", state=" + state + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((targetcontent == null) ? 0 : targetcontent.hashCode());
		result = prime * result + ((targetid == null) ? 0 : targetid.hashCode());
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
		TargetBean other = (TargetBean) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (targetcontent == null) {
			if (other.targetcontent != null)
				return false;
		} else if (!targetcontent.equals(other.targetcontent))
			return false;
		if (targetid == null) {
			if (other.targetid != null)
				return false;
		} else if (!targetid.equals(other.targetid))
			return false;
		return true;
	}
	
}
