package com.usa.ciclo3.ciclo3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "administratorsUsers")
public class AdministratorsUsers implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAdminUser;

	@Column(length = 250)
	private String userName;

	@Column(length = 45)
	private String userMail;

	@Column(length = 45)
	@JsonIgnoreProperties("userPassword")
	private String userPassword;

	public Integer getIdAdminUser() {
		return idAdminUser;
	}

	public void setIdAdminUser(Integer idAdminUser) {
		this.idAdminUser = idAdminUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
