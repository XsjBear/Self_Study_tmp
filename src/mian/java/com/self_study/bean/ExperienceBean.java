package com.self_study.bean;

public class ExperienceBean {
	
	private String experienceid;
	private String experiencetype;
	public ExperienceBean(String experienceid, String experiencetype) {
		super();
		this.experienceid = experienceid;
		this.experiencetype = experiencetype;
	}
	public ExperienceBean() {
		super();
	}
	public String getExperienceid() {
		return experienceid;
	}
	public void setExperienceid(String experienceid) {
		this.experienceid = experienceid;
	}
	public String getExperiencetype() {
		return experiencetype;
	}
	public void setExperiencetype(String experiencetype) {
		this.experiencetype = experiencetype;
	}
	@Override
	public String toString() {
		return "ExperienceBean [experienceid=" + experienceid + ", experiencetype=" + experiencetype + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((experiencetype == null) ? 0 : experiencetype.hashCode());
		result = prime * result + ((experienceid == null) ? 0 : experienceid.hashCode());
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
		ExperienceBean other = (ExperienceBean) obj;
		if (experiencetype == null) {
			if (other.experiencetype != null)
				return false;
		} else if (!experiencetype.equals(other.experiencetype))
			return false;
		if (experienceid == null) {
			if (other.experienceid != null)
				return false;
		} else if (!experienceid.equals(other.experienceid))
			return false;
		return true;
	}
	
}
