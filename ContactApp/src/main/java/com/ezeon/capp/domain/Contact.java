package com.ezeon.capp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact",catalog = "capp_db")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contactid")
	private Integer contactId;//PK
	
	@Column(name = "userid")
	private Integer userId;//FK
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "remark")
	private String remark;
	
	public Contact() {
		super();
	}
	
	public Integer getContactId() {
		return contactId;
	}
	public Contact setContactId(Integer contactId) {
		this.contactId = contactId;
		return this;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public Contact setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public Contact setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getPhone() {
		return phone;
	}
	public Contact setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	public Contact setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getAddress() {
		return address;
	}
	public Contact setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public String getRemark() {
		return remark;
	}
	public Contact setRemark(String remark) {
		this.remark = remark;
		return this;
	}
	
}
