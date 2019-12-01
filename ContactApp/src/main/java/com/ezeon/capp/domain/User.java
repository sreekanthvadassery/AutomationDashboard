package com.ezeon.capp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user",catalog = "capp_db")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private Integer userId;

	@Column(name="name")
	private String name;

	@Column(name="phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name="address")
	private String address;

	@Column(name = "loginname")
	private String loginName;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private Integer role;

	@Column(name = "loginstatus")
	private Integer loginStatus;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private List<Contact> contacts;

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}
	public User setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getPhone() {
		return phone;
	}
	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getAddress() {
		return address;
	}
	public User setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getLoginName() {
		return loginName;
	}
	public User setLoginName(String loginName) {
		this.loginName = loginName;
		return this;
	}

	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public Integer getRole() {
		return role;
	}
	public User setRole(Integer role) {
		this.role = role;
		return this;
	}

	public Integer getLoginStatus() {
		return loginStatus;
	}
	public User setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
		return this;
	}

}
