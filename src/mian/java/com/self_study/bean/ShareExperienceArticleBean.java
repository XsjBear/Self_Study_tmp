package com.self_study.bean;

import java.io.Serializable;

public class ShareExperienceArticleBean implements Serializable{
	
	private String shareid;
	private String nickname;
	private String experiencetype;	//类型名字
	private String experience_title;
	private String annoce_time;
	private String experience_content;
	public ShareExperienceArticleBean(String shareid, String nickname, String experiencetype, String experience_title,
			String annoce_time, String experience_content) {
		super();
		this.shareid = shareid;
		this.nickname = nickname;
		this.experiencetype = experiencetype;
		this.experience_title = experience_title;
		this.annoce_time = annoce_time;
		this.experience_content = experience_content;
	}
	public ShareExperienceArticleBean() {
		super();
	}
	public String getShareid() {
		return shareid;
	}
	public void setShareid(String shareid) {
		this.shareid = shareid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getExperiencetype() {
		return experiencetype;
	}
	public void setExperiencetype(String experiencetype) {
		this.experiencetype = experiencetype;
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
		return "ShareExperienceArticleBean [shareid=" + shareid + ", nickname=" + nickname + ", experiencetype="
				+ experiencetype + ", experience_title=" + experience_title + ", annoce_time=" + annoce_time
				+ ", experience_content=" + experience_content + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annoce_time == null) ? 0 : annoce_time.hashCode());
		result = prime * result + ((experience_content == null) ? 0 : experience_content.hashCode());
		result = prime * result + ((experience_title == null) ? 0 : experience_title.hashCode());
		result = prime * result + ((experiencetype == null) ? 0 : experiencetype.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((shareid == null) ? 0 : shareid.hashCode());
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
		ShareExperienceArticleBean other = (ShareExperienceArticleBean) obj;
		if (annoce_time == null) {
			if (other.annoce_time != null)
				return false;
		} else if (!annoce_time.equals(other.annoce_time))
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
		if (experiencetype == null) {
			if (other.experiencetype != null)
				return false;
		} else if (!experiencetype.equals(other.experiencetype))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (shareid == null) {
			if (other.shareid != null)
				return false;
		} else if (!shareid.equals(other.shareid))
			return false;
		return true;
	}
}
