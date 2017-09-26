package com.example.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "per_id")
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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@ManyToOne(optional=false)
	@NotNull(message = "*Please provide module")
	@JoinColumn(name = "mod_id",nullable = false)
	public Module module;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "authorization", 
	joinColumns = @JoinColumn(name = "per_id"), 
	inverseJoinColumns = @JoinColumn(name = "pos_id"))
	
	public Set<Position> position;

	public Set<Position> getPosition() {
		return position;
	}

	public void setPosition(Set<Position> position) {
		this.position = position;
	}
	
	
}
