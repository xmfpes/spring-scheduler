package com.kyunam.springscheduler.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Member {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=25, unique=true)
	private String uid;
	
	@Column(nullable=false)
	private String upw;
	
	@Column(nullable=false, length=25)
	private String uname;
	
	@Column(length=50)
	private String uemail;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="member")
	private List<MemberRole> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public List<MemberRole> getRoles() {
		return roles;
	}

	public void setRoles(List<MemberRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uemail=" + uemail
				+ ", roles=" + roles + "]";
	}
	

}
