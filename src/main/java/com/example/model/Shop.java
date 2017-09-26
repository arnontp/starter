package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "shop")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shop_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "name") 
	@NotEmpty(message = "*Please provide an name")
	private String name;
	
	@Column(name = "address") 
	@NotEmpty(message = "*Please provide an address")
	private String address;
	
	@Column(name = "phone") 
	@NotEmpty(message = "*Please provide an phone")
	private String phone;
	
	@Column(name = "mobile") 
	@NotEmpty(message = "*Please provide an mobile")
	private String mobile;
	
	@Column(name = "facebook") 
	@NotEmpty(message = "*Please provide an facebook")
	private String facebook;
	
	@Column(name = "line") 
	@NotEmpty(message = "*Please provide an line")
	private String line;
	
	@Column(name = "email") 
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Column(name = "view") 
	@NotEmpty(message = "*Please provide an view")
	private int view;
	
	@Column(name = "love") 
	@NotEmpty(message = "*Please provide an love")
	private int love;
	
	@Column(name = "active") 
	@NotEmpty(message = "*Please provide an active")
	private int active;
	
	@Column(name = "created") 
	@NotEmpty(message = "*Please provide an created")
	private Date created;
	
 
	
	  
	
	
	


}
