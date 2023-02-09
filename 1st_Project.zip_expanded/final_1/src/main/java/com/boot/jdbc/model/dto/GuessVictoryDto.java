package com.boot.jdbc.model.dto;

// DB랑 변수명 다름
public class GuessVictoryDto {
	private String id;
	private String nation1;
	private String nation2;
	private String nationImg1;
	private String nationImg2;
	private int voteRates1;
	private int voteRates2;
	private String votedNation;
	private String playTime;
	private String playDate;
	
	public GuessVictoryDto() {
		super();
	}

	public GuessVictoryDto(String id, String nation1, String nation2, String nationImg1, String nationImg2,
			int voteRates1, int voteRates2, String votedNation, String playTime, String playDate) {
		super();
		this.id = id;
		this.nation1 = nation1;
		this.nation2 = nation2;
		this.nationImg1 = nationImg1;
		this.nationImg2 = nationImg2;
		this.voteRates1 = voteRates1;
		this.voteRates2 = voteRates2;
		this.votedNation = votedNation;
		this.playTime = playTime;
		this.playDate = playDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNation1() {
		return nation1;
	}

	public void setNation1(String nation1) {
		this.nation1 = nation1;
	}

	public String getNation2() {
		return nation2;
	}

	public void setNation2(String nation2) {
		this.nation2 = nation2;
	}

	public String getNationImg1() {
		return nationImg1;
	}

	public void setNationImg1(String nationImg1) {
		this.nationImg1 = nationImg1;
	}

	public String getNationImg2() {
		return nationImg2;
	}

	public void setNationImg2(String nationImg2) {
		this.nationImg2 = nationImg2;
	}

	public int getVoteRates1() {
		return voteRates1;
	}

	public void setVoteRates1(int voteRates1) {
		this.voteRates1 = voteRates1;
	}

	public int getVoteRates2() {
		return voteRates2;
	}

	public void setVoteRates2(int voteRates2) {
		this.voteRates2 = voteRates2;
	}

	public String getVotedNation() {
		return votedNation;
	}

	public void setVotedNation(String votedNation) {
		this.votedNation = votedNation;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getPlayDate() {
		return playDate;
	}

	public void setPlayDate(String playDate) {
		this.playDate = playDate;
	}
	
}
