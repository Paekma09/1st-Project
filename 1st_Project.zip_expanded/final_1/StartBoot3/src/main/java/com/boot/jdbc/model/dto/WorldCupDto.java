package com.boot.jdbc.model.dto;

public class WorldCupDto {
private int mynumber;
private String mygroup;
private String myenemy;
private String myregdate;
private String mycontent;
private String myresult;
public WorldCupDto(int mynumber, String mygroup, String myenemy, String myregdate, String mycontent, String myresult) {
	super();
	this.mynumber = mynumber;
	this.mygroup = mygroup;
	this.myenemy = myenemy;
	this.myregdate = myregdate;
	this.mycontent = mycontent;
	this.myresult = myresult;
}
public int getMynumber() {
	return mynumber;
}
public void setMynumber(int mynumber) {
	this.mynumber = mynumber;
}
public String getMygroup() {
	return mygroup;
}
public void setMygroup(String mygroup) {
	this.mygroup = mygroup;
}
public String getMyenemy() {
	return myenemy;
}
public void setMyenemy(String myenemy) {
	this.myenemy = myenemy;
}
public String getMyregdate() {
	return myregdate;
}
public void setMyregdate(String myregdate) {
	this.myregdate = myregdate;
}
public String getMycontent() {
	return mycontent;
}
public void setMycontent(String mycontent) {
	this.mycontent = mycontent;
}
public String getMyresult() {
	return myresult;
}
public void setMyresult(String myresult) {
	this.myresult = myresult;
}



}
