package org.hyunkyo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String user_id;

	private String user_nm;
	private String email;
	private Date reg_date;

	public User() {}

	public User(String user_id, String user_nm, String email, Date reg_date) {
		super();
		this.user_id = user_id;
		this.user_nm = user_nm;
		this.email = email;
		this.reg_date = reg_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_nm=" + user_nm + ", email=" + email + ", reg_date=" + reg_date
				+ "]";
	}

}
