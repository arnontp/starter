package com.example.model;

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

@Entity
@Table(name = "position")
public class Position {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pos_id")
	public int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="name")
	public String name;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "div_id")
	public Division division;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "authorization", 
	joinColumns = @JoinColumn(name = "pos_id"), 
	inverseJoinColumns = @JoinColumn(name = "per_id"))
	
	public Set<Permission> permission;

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}

}
