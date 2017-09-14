package com.kyunam.springscheduler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class MemberRole {
	@Id
	@GeneratedValue
	private Long uno;

	private String roleName;

	public Long getUno() {
		return uno;
	}

	public void setUno(Long uno) {
		this.uno = uno;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "MemberRole [uno=" + uno + ", roleName=" + roleName + "]";
	}
	
}
