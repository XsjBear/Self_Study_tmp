package com.self_study.bean;

import java.io.Serializable;

/**
 * 我的小伙伴bean
 * @author Xsj
 *
 */
public class FriendShipBean implements Serializable{
	
	private String friendshipid;
	private String selfuserid;
	private String frienduserid;
	private String buildrelationtime;
	private String relationshipstate;
	public FriendShipBean(String friendshipid, String selfuserid, String frienduserid, String buildrelationtime,
			String relationshipstate) {
		super();
		this.friendshipid = friendshipid;
		this.selfuserid = selfuserid;
		this.frienduserid = frienduserid;
		this.buildrelationtime = buildrelationtime;
		this.relationshipstate = relationshipstate;
	}
	public FriendShipBean() {
		super();
	}
	public String getFriendshipid() {
		return friendshipid;
	}
	public void setFriendshipid(String friendshipid) {
		this.friendshipid = friendshipid;
	}
	public String getSelfuserid() {
		return selfuserid;
	}
	public void setSelfuserid(String selfuserid) {
		this.selfuserid = selfuserid;
	}
	public String getFrienduserid() {
		return frienduserid;
	}
	public void setFrienduserid(String frienduserid) {
		this.frienduserid = frienduserid;
	}
	public String getBuildrelationtime() {
		return buildrelationtime;
	}
	public void setBuildrelationtime(String buildrelationtime) {
		this.buildrelationtime = buildrelationtime;
	}
	public String getRelationshipstate() {
		return relationshipstate;
	}
	public void setRelationshipstate(String relationshipstate) {
		this.relationshipstate = relationshipstate;
	}
	@Override
	public String toString() {
		return "FriendShipBean [friendshipid=" + friendshipid + ", selfuserid=" + selfuserid + ", frienduserid="
				+ frienduserid + ", buildrelationtime=" + buildrelationtime + ", relationshipstate=" + relationshipstate
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildrelationtime == null) ? 0 : buildrelationtime.hashCode());
		result = prime * result + ((friendshipid == null) ? 0 : friendshipid.hashCode());
		result = prime * result + ((frienduserid == null) ? 0 : frienduserid.hashCode());
		result = prime * result + ((relationshipstate == null) ? 0 : relationshipstate.hashCode());
		result = prime * result + ((selfuserid == null) ? 0 : selfuserid.hashCode());
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
		FriendShipBean other = (FriendShipBean) obj;
		if (buildrelationtime == null) {
			if (other.buildrelationtime != null)
				return false;
		} else if (!buildrelationtime.equals(other.buildrelationtime))
			return false;
		if (friendshipid == null) {
			if (other.friendshipid != null)
				return false;
		} else if (!friendshipid.equals(other.friendshipid))
			return false;
		if (frienduserid == null) {
			if (other.frienduserid != null)
				return false;
		} else if (!frienduserid.equals(other.frienduserid))
			return false;
		if (relationshipstate == null) {
			if (other.relationshipstate != null)
				return false;
		} else if (!relationshipstate.equals(other.relationshipstate))
			return false;
		if (selfuserid == null) {
			if (other.selfuserid != null)
				return false;
		} else if (!selfuserid.equals(other.selfuserid))
			return false;
		return true;
	}
}
