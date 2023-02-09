package com.boot.jdbc.model.biz;

import java.util.List;
import com.boot.jdbc.model.dto.GuessVictoryDto;

public interface GuessVictoryBiz {
	public String isVoted(String playTime, String playDate); // 투표 여부
	public int insertVote1(String nation1, String playDate); // 나라1 투표
	public int insertVote2(String nation2, String playDate); // 나라2 투표
	public int changeVote1To2(String nation2, String playDate); // 투표 변경 (나라1 -> 나라2) 
	public int changeVote2To1(String nation1, String playDate); // 투표 변경 (나라2 -> 나라1) 
	public String getVoteRates1(String playTime, String playDate); // 나라1 득표율 가져오기
	public String getVoteRates2(String playTime, String playDate); // 나라2 득표율 가져오기
	public List<GuessVictoryDto> selectList(); // 일주일 경기 가져오기

}
