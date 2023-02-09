package com.boot.jdbc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.jdbc.model.dto.GuessVictoryDto;

@Mapper
public interface GuessVictoryMapper {
	// 투표 여부
	@Select("SELECT VOTESTATUS FROM GUESSVICTORY WHERE PLAYTIME = #{playTime} AND PLAYDATE = STR_TO_DATE(#{playDate}, '%Y-%m-%d')")
	public String isVoted(String playTime, String playDate);
	
	// 나라1 투표
	@Update("UPDATE GUESSVICTORY SET VOTENUM1 = VOTENUM1 + 1, VOTESTATUS = #{nation1} WHERE NATION1 = #{nation1} AND PLAYDATE = STR_TO_DATE(#{playDate}, '%Y-%m-%d')")
	public int insertVote1(String nation1, String playDate);
	
	// 나라2 투표
	@Update("UPDATE GUESSVICTORY SET VOTENUM2 = VOTENUM2 + 1, VOTESTATUS = #{nation2} WHERE NATION2 = #{nation2} AND PLAYDATE = STR_TO_DATE(#{playDate}, '%Y-%m-%d')")
	public int insertVote2(String nation2, String playDate);
	
	// 투표 변경 (나라1 -> 나라2) 
	@Update("UPDATE GUESSVICTORY SET VOTENUM2 = VOTENUM2 + 1, VOTENUM1 = VOTENUM1 - 1, VOTESTATUS = #{nation2} WHERE NATION2 = #{nation2} AND PLAYDATE = STR_TO_DATE(#{playDate}, '%Y-%m-%d')")
	public int changeVote1To2(String nation2, String playDate);
	
	// 투표 변경 (나라2 -> 나라1)
	@Update("UPDATE GUESSVICTORY SET VOTENUM1 = VOTENUM1 + 1, VOTENUM2 = VOTENUM2 - 1, VOTESTATUS = #{nation1} WHERE NATION1 = #{nation1} AND PLAYDATE = STR_TO_DATE(#{playDate}, '%Y-%m-%d')")
	public int changeVote2To1(String nation1, String playDate);
	
	// 나라1 득표율 가져오기
	@Select("SELECT ROUND(((SELECT VOTENUM1 FROM GUESSVICTORY WHERE PLAYTIME = #{playTime} AND PLAYDATE = STR_TO_DATE(#{playDate}, '%Y-%m-%d')) / SUM(VOTENUM1 + VOTENUM2)) * 100) FROM GUESSVICTORY WHERE PLAYTIME = #{playTime} AND PLAYDATE = STR_TO_DATE(#{playDate}, '%Y-%m-%d')")
	public String getVoteRates1(String playTime, String playDate);
	
	// 나라2 득표율 가져오기
	@Select("SELECT ROUND(((SELECT VOTENUM2 FROM GUESSVICTORY WHERE PLAYTIME = #{playTime} AND PLAYDATE = STR_TO_DATE(#{playDate}, '%Y-%m-%d')) / SUM(VOTENUM1 + VOTENUM2)) * 100) FROM GUESSVICTORY WHERE PLAYTIME = #{playTime} AND PLAYDATE = STR_TO_DATE(#{playDate}, '%Y-%m-%d')")
	public String getVoteRates2(String playTime, String playDate);
	
	// 일주일 경기 가져오기
	@Select("SELECT * FROM GUESSVICTORY WHERE PLAYDATE  BETWEEN  DATE_FORMAT(NOW(),'%Y-%m-%d') AND DATE_ADD(DATE_FORMAT(NOW(),'%Y-%m-%d'), INTERVAL 7 DAY) ORDER BY PLAYDATE")
	public List<GuessVictoryDto> selectList();
}
