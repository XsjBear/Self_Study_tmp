package com.self_study.bean;

import java.io.Serializable;

public class ShareExperienceBean implements Serializable{
	
	private String shareid;
	private String userid;
	private String experience;	//类型名字
	private String experience_title;
	private String annoce_time;
	private String experience_content;
	public ShareExperienceBean(String shareid, String userid, String experience, String experience_title,
			String annoce_time, String experience_content) {
		super();
		this.shareid = shareid;
		this.userid = userid;
		this.experience = experience;
		this.experience_title = experience_title;
		this.annoce_time = annoce_time;
		this.experience_content = experience_content;
	}
	public ShareExperienceBean() {
		super();
	}
	public String getShareid() {
		return shareid;
	}
	public void setShareid(String shareid) {
		this.shareid = shareid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getExperience_title() {
		return experience_title;
	}
	public void setExperience_title(String experience_title) {
		this.experience_title = experience_title;
	}
	public String getAnnoce_time() {
		return annoce_time;
	}
	public void setAnnoce_time(String annoce_time) {
		this.annoce_time = annoce_time;
	}
	public String getExperience_content() {
		return experience_content;
	}
	public void setExperience_content(String experience_content) {
		this.experience_content = experience_content;
	}
	@Override
	public String toString() {
		return "ShareExperienceBean [shareid=" + shareid + ", userid=" + userid + ", experience=" + experience
				+ ", experience_title=" + experience_title + ", annoce_time=" + annoce_time + ", experience_content="
				+ experience_content + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annoce_time == null) ? 0 : annoce_time.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + ((experience_content == null) ? 0 : experience_content.hashCode());
		result = prime * result + ((experience_title == null) ? 0 : experience_title.hashCode());
		result = prime * result + ((shareid == null) ? 0 : shareid.hashCode());
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
		ShareExperienceBean other = (ShareExperienceBean) obj;
		if (annoce_time == null) {
			if (other.annoce_time != null)
				return false;
		} else if (!annoce_time.equals(other.annoce_time))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (experience_content == null) {
			if (other.experience_content != null)
				return false;
		} else if (!experience_content.equals(other.experience_content))
			return false;
		if (experience_title == null) {
			if (other.experience_title != null)
				return false;
		} else if (!experience_title.equals(other.experience_title))
			return false;
		if (shareid == null) {
			if (other.shareid != null)
				return false;
		} else if (!shareid.equals(other.shareid))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

}
