package com.boot.jdbc.model.dto;

import java.util.Date;

public class HighlightCommentDto {
	
	private int cono;
	private int hino;
	private String codetail;
	private Date codate;
	private String id;
	private String name;
	
	public HighlightCommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HighlightCommentDto(int cono, int hino, String codetail, Date codate, String id, String name) {
		super();
		this.cono = cono;
		this.hino = hino;
		this.codetail = codetail;
		this.codate = codate;
		this.id = id;
		this.name = name;
	}
	public int getCono() {
		return cono;
	}
	public void setCono(int cono) {
		this.cono = cono;
	}
	public int getHino() {
		return hino;
	}
	public void setHino(int hino) {
		this.hino = hino;
	}
	public String getCodetail() {
		return codetail;
	}
	public void setCodetail(String codetail) {
		this.codetail = codetail;
	}
	public Date getCodate() {
		return codate;
	}
	public void setCodate(Date codate) {
		this.codate = codate;
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
	
	
	

}
