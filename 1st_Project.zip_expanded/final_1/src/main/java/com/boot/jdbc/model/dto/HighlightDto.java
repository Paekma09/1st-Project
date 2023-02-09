
package com.boot.jdbc.model.dto;

import java.util.Date;

public class HighlightDto {
	private int hino;
	private String hititle;
	private String hipath;
	private Date hidate;
	private int hireadcount;
	private int commentcount;
	public HighlightDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HighlightDto(int hino, String hititle, String hipath, Date hidate, int hireadcount, int commentcount) {
		super();
		this.hino = hino;
		this.hititle = hititle;
		this.hipath = hipath;
		this.hidate = hidate;
		this.hireadcount = hireadcount;
		this.commentcount = commentcount;
	}
	public int getHino() {
		return hino;
	}
	public void setHino(int hino) {
		this.hino = hino;
	}
	public String getHititle() {
		return hititle;
	}
	public void setHititle(String hititle) {
		this.hititle = hititle;
	}
	public String getHipath() {
		return hipath;
	}
	public void setHipath(String hipath) {
		this.hipath = hipath;
	}
	public Date getHidate() {
		return hidate;
	}
	public void setHidate(Date hidate) {
		this.hidate = hidate;
	}
	public int getHireadcount() {
		return hireadcount;
	}
	public void setHireadcount(int hireadcount) {
		this.hireadcount = hireadcount;
	}
	public int getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
	 
	
}
