package com.example.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	private int id;
	
	@Column(name = "name")	 
	private String name;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "created")
	private Timestamp created;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public List<Division> division;
	
	
	
	public List<Division> getDivision() {
		return division;
	}
	public void setDivision(List<Division> division) {
		this.division = division;
	}
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
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
}
