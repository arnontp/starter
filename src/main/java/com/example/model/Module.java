package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "module")
public class Module {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mod_id")
	public int id;
	
	@Column(name = "code")
	@NotEmpty(message = "*Please provide code")
	public String code;
	
	@Column(name = "name")
	@NotEmpty(message = "*Please provide name")
	public String name;
	 
	@Column(name = "created") 
	@CreationTimestamp
	public Date created;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Column(name = "updated") 
	@UpdateTimestamp
	public Date updated;
	
	@Column(name = "active") 	
	public int active;
	


}
