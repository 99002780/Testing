package com.example.demo.dto;

public class ContestantDto {
@Override
	public String toString() {
		return "ContestantDto [id=" + id + ", name=" + name + ", emailId=" + emailId + ", contestName=" + contestName
				+ ", phoneNo=" + phoneNo + "]";
	}
private long id;
	
	
	private String name;
	private String emailId;
	private String contestName;
	private String phoneNo;
	
	public ContestantDto(long id, String name, String emailId, String contestName, String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.contestName = contestName;
		this.phoneNo = phoneNo;
	}
	public ContestantDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContestName() {
		return contestName;
	}
	public void setContestName(String contestName) {
		this.contestName = contestName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
