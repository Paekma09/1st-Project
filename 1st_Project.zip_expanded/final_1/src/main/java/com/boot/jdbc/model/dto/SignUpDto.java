package com.boot.jdbc.model.dto;


public class SignUpDto {
	private String id;
	private String pw;
	private String name;
	private String signUpYN;
	
	public SignUpDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUpDto(String id, String pw, String name, String signUpYN) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.signUpYN = signUpYN;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignUpYN() {
		return signUpYN;
	}

	public void setSignUpYN(String signUpYN) {
		this.signUpYN = signUpYN;
	}
	
	
}
