package com.self_study.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 用户实体类
 * @author Xsj
 *
 */
@Component
public class UserInfoBean implements Serializable{
	
	private int userid;//用户id
	private String nickname;//用户昵称
	private String realname;//用户真实姓名
	private String pwd;//用户密码
	private String sex;//用户性别
	private String birthday;//用户出生年月日
	private String tel;//用户电话号码
	private String qq;//用户QQ
	private String mail;//用户邮箱
	private String wechat;//用户微信
	private String school;//用户就读学校
	private String stu_num;//用户学号
	private String major;//用户所修主专业
	private String class_num;//用户班级
	
	
	
	
	
	/**
	 * 无参构造
	 */
	public UserInfoBean() {
		super();
	}
	
	/**
	 * 有参构造
	 * @param userid
	 * @param nickname
	 * @param realname
	 * @param pwd
	 * @param sex
	 * @param birthday
	 * @param tel
	 * @param qq
	 * @param mail
	 * @param wechat
	 * @param school
	 * @param stu_num
	 * @param major
	 * @param class_num
	 */
	public UserInfoBean(int userid, String nickname, String realname, String pwd, String sex, String birthday,
			String tel, String qq, String mail, String wechat, String school, String stu_num, String major,
			String class_num) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.realname = realname;
		this.pwd = pwd;
		this.sex = sex;
		this.birthday = birthday;
		this.tel = tel;
		this.qq = qq;
		this.mail = mail;
		this.wechat = wechat;
		this.school = school;
		this.stu_num = stu_num;
		this.major = major;
		this.class_num = class_num;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getStu_num() {
		return stu_num;
	}
	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClass_num() {
		return class_num;
	}
	public void setClass_num(String class_num) {
		this.class_num = class_num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((class_num == null) ? 0 : class_num.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
		result = prime * result + ((realname == null) ? 0 : realname.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((stu_num == null) ? 0 : stu_num.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + userid;
		result = prime * result + ((wechat == null) ? 0 : wechat.hashCode());
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
		UserInfoBean other = (UserInfoBean) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (class_num == null) {
			if (other.class_num != null)
				return false;
		} else if (!class_num.equals(other.class_num))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
			return false;
		if (realname == null) {
			if (other.realname != null)
				return false;
		} else if (!realname.equals(other.realname))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (stu_num == null) {
			if (other.stu_num != null)
				return false;
		} else if (!stu_num.equals(other.stu_num))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (userid != other.userid)
			return false;
		if (wechat == null) {
			if (other.wechat != null)
				return false;
		} else if (!wechat.equals(other.wechat))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserInfoBean [userid=" + userid + ", nickname=" + nickname + ", realname=" + realname + ", pwd=" + pwd
				+ ", sex=" + sex + ", birthday=" + birthday + ", tel=" + tel + ", qq=" + qq + ", mail=" + mail
				+ ", wechat=" + wechat + ", school=" + school + ", stu_num=" + stu_num + ", major=" + major
				+ ", class_num=" + class_num + "]";
	}
	
}
