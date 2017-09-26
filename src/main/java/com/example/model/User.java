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
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public int id;
	
	@Column(name = "username")
//	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide username")
	public String username;
	
	@Column(name = "password")
//	@Length(min = 5,max = 10,message = "*Password must 5 - 10 characters")
	@NotEmpty(message = "*Please provide password")	 
	public String password;
	
	@Column(name = "name")
	@NotEmpty(message = "*Please provide name")
	public String name;
	
	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide last name")
	public String lastName;
	
	@Column(name = "active")
	public int active;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	
	public Set<Role> roles;
	
	@Column(name = "code")
	@NotEmpty(message = "*Please provide code")
	public String code;
	
 
	@ManyToOne(optional=false)
	@NotNull(message = "*Please provide location")
	@JoinColumn(name = "loc_id",nullable = false)
	public Location location;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNameEnglish() {
		return nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getProdateMid() {
		return prodateMid;
	}

	public void setProdateMid(Date prodateMid) {
		this.prodateMid = prodateMid;
	}

	public Date getProdateFinal() {
		return prodateFinal;
	}

	public void setProdateFinal(Date prodateFinal) {
		this.prodateFinal = prodateFinal;
	}

	public Date getProdateEnd() {
		return prodateEnd;
	}

	public void setProdateEnd(Date prodateEnd) {
		this.prodateEnd = prodateEnd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephonePrivate() {
		return telephonePrivate;
	}

	public void setTelephonePrivate(String telephonePrivate) {
		this.telephonePrivate = telephonePrivate;
	}

	public String getTelephoneCompany() {
		return telephoneCompany;
	}

	public void setTelephoneCompany(String telephoneCompany) {
		this.telephoneCompany = telephoneCompany;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getBookbankNo() {
		return bookbankNo;
	}

	public void setBookbankNo(String bookbankNo) {
		this.bookbankNo = bookbankNo;
	}

	public String getBookbankBranch() {
		return bookbankBranch;
	}

	public void setBookbankBranch(String bookbankBranch) {
		this.bookbankBranch = bookbankBranch;
	}

	public Date getBirthdayCard() {
		return birthdayCard;
	}

	public void setBirthdayCard(Date birthdayCard) {
		this.birthdayCard = birthdayCard;
	}

	public Date getBirthdayBorn() {
		return birthdayBorn;
	}

	public void setBirthdayBorn(Date birthdayBorn) {
		this.birthdayBorn = birthdayBorn;
	}

	public String getRecruitmentSource() {
		return recruitmentSource;
	}

	public void setRecruitmentSource(String recruitmentSource) {
		this.recruitmentSource = recruitmentSource;
	}
 
	@ManyToOne(optional=false)
	@NotNull(message = "*Please provide contract")
	@JoinColumn(name = "con_id",nullable = false)
	public Contract contract;
	 
	@ManyToOne(optional=false)
	@NotNull(message = "*Please provide position")
	@JoinColumn(name = "pos_id",nullable = false)
	public Position position;
	  
	 
	@Column(name = "nickname")
	@NotEmpty(message = "*Please provide nickname")
	public String nickName;
	
	@Column(name = "gender")
	@NotEmpty(message = "*Please provide gender")
	public String gender;
	
	@Column(name = "name_english")
	@NotEmpty(message = "*Please provide name english")
	public String nameEnglish;
	

	
	@Column(name = "startdate")
	@NotNull(message = "*Please provide start date")
	public Date startDate;
	
	
	@Column(name = "prodate_mid",nullable=false)
	@NotNull(message = "*Please provide pro mid date")
	public Date prodateMid;
	
	
	@Column(name = "prodate_final",nullable=false)
	@NotNull(message = "*Please provide pro final date")
	public Date prodateFinal;
	
	
	@Column(name = "prodate_end",nullable=false)
	@NotNull(message = "*Please provide pro end date")
	public Date prodateEnd;
	
	@Column(name = "email")
	@NotEmpty(message = "*Please provide email")
	public String email;
	
	@Column(name = "address")
	@NotEmpty(message = "*Please provide address")
	public String address;
	
	@Column(name = "telephone_private")
	@NotEmpty(message = "*Please provide telephone")
	public String telephonePrivate;
	
	@Column(name = "telephone_company")
	public String telephoneCompany;
	
	@Column(name = "card_id")
	@NotEmpty(message = "*Please provide card id")
	public String cardId;
	
	@Column(name = "bookbank_no")
	@NotEmpty(message = "*Please provide book bank")
	public String bookbankNo;
	
	@Column(name = "bookbank_branch")
	@NotEmpty(message = "*Please provide bank branch")
	public String bookbankBranch;
	
	
	@Column(name = "birthday_card",nullable=false)
	@NotNull(message = "*Please provide birthday") 
	public Date birthdayCard;
	
	
	@Column(name = "birthday_born",nullable=false)	
	public Date birthdayBorn;
	
	@Column(name = "recruitment_source")
	@NotEmpty(message = "*Please provide recruitment ")
	public String recruitmentSource;
	
	@Column(name = "created") 
	@CreationTimestamp
	public Date created;
	
	@Column(name = "updated") 
	@UpdateTimestamp
	public Date updated;

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

	 
	 
	
  

}
