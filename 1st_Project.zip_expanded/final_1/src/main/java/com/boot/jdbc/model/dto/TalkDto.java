package com.boot.jdbc.model.dto;

public class TalkDto {
	private int tno;
	private String id;
	private String name;
	private String tcontent;
	private String tdate;
	
	public TalkDto() {
		super();
	}
	public TalkDto(int tno, String id, String name, String tcontent, String tdate) {
		super();
		this.tno = tno;
		this.id = id;
		this.name = name;
		this.tcontent = tcontent;
		this.tdate = tdate;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	@Override
	public String toString() {
		return "TalkDto [tno=" + tno + ", id=" + id + ", name=" + name + ", tcontent=" + tcontent + ", tdate=" + tdate
				+ "]";
	}
}
