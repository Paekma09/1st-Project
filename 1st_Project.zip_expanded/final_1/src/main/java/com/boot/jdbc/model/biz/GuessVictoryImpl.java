package com.boot.jdbc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jdbc.model.dao.GuessVictoryMapper;
import com.boot.jdbc.model.dto.GuessVictoryDto;

@Service
public class GuessVictoryImpl implements GuessVictoryBiz{

	@Autowired
	private GuessVictoryMapper guessVictoryMapper;
	
	@Override
	public String isVoted(String playTime, String playDate) {
		return guessVictoryMapper.isVoted(playTime, playDate);
	}

	@Override
	public int insertVote1(String nation1, String playDate) {
		return guessVictoryMapper.insertVote1(nation1, playDate);
	}
	
	@Override
	public int insertVote2(String nation2, String playDate) {
		return guessVictoryMapper.insertVote2(nation2, playDate);
	}

	@Override
	public int changeVote1To2(String nation2, String playDate) {
		return guessVictoryMapper.changeVote1To2(nation2, playDate);
	}
	
	@Override
	public int changeVote2To1(String nation1, String playDate) {
		return guessVictoryMapper.changeVote2To1(nation1, playDate);
	}

	@Override
	public String getVoteRates1(String playTime, String playDate) {
		return guessVictoryMapper.getVoteRates1(playTime, playDate);
	}

	@Override
	public String getVoteRates2(String playTime, String playDate) {
		return guessVictoryMapper.getVoteRates2(playTime, playDate);
	}
	
	@Override
	public List<GuessVictoryDto> selectList() {
		return guessVictoryMapper.selectList();
	}
}
