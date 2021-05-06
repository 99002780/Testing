package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contest")
public class Contestant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "contest_name")
	private String contestName;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	public Contestant() {
		
	}
	
	public Contestant(long id, String name, String emailId, String contestName, String phoneNo) {
		super();
		this.id = id;
		this.name =name;
		this.emailId = emailId;
		this.contestName =contestName;
		this.phoneNo = phoneNo;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContestName() {
		return contestName;
	}

	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
