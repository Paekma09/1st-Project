package com.test.jdbc.model.dao;
import java.util.Date;
/*CREATE TABLE `BOARD` (
`BOARDID`	INT	NOT NULL,
`TITLE`	VARCHAR(100)	NOT NULL,
`CONTENT`	TEXT	NOT NULL,
`REGDATE`	DATETIME	NOT NULL,
`UPDATEDATE`	DATETIME	NOT NULL,
`READCOUNT`	INT	NOT NULL	DEFAULT 0,
`LIKE`	INT	NOT NULL	DEFAULT 0,
`ID`	VARCHAR(100)	NOT NULL*/
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.jdbc.model.dto.BoardDto;
import com.test.jdbc.model.dto.CommentDto;

@Mapper
public interface BoardMapper {
	
	@Select(" "
			+ " SELECT "
				+ 	"board_seq as boardSeq, "
				+ 	"title, "
				+ 	"content, "
				+ 	"reg_date as regDate, "
				+	"update_date as updateDate, "
				+ 	"read_count as readCount, "
				+ 	"board.like, "
				+ 	"id, "
				+ " (select count(board_comment.comment_seq) "
				+ "				from board_comment"
				+ "				where board_seq=boardSeq) cntComment "
			+ "FROM "
			+ 	"BOARD "
			+ "ORDER BY "
			+ 	"boardSeq DESC ")
	List<BoardDto> selectList();
	
	@Insert(" INSERT INTO BOARD VALUES(#{boardSeq}, #{title}, #{content}, NOW(), NOW(), #{readCount}, #{like}, #{id}, #{cntComment}) ")
	int insert(BoardDto dto);
	
	@Select(" "
			+ " SELECT "
				+ 	"board_seq as boardSeq, "
				+ 	"title, "
				+ 	"content, "
				+ 	"reg_date as regDate, "
				+	"update_date as updateDate, "
				+ 	"read_count as readCount, "
				+ 	"board.like, "
				+ 	"id, "
				+ " (select count(board_comment.comment_seq) "
				+ "				from board_comment"
				+ "				where board_seq=boardSeq) cntComment "
			+ "FROM "
			+ 	"BOARD "
			+ "WHERE "
			+ 	"BOARD_SEQ=#{boardSeq}"
			)
	BoardDto selectOne(int boardSeq);
	
	@Update(" UPDATE BOARD SET TITLE=#{title}, CONTENT=#{content} WHERE BOARD_SEQ=#{boardSeq} ")
	int update(BoardDto dto);
	
	@Delete(" DELETE FROM BOARD WHERE BOARD_SEQ = #{boardSeq} ")
	int delete(int boardSeq);
	
	@Update("update board set read_count = read_count + 1 where board_seq = #{boardSeq}")
	int cntUpdate(int boardSeq);
	
	@Update(" update board "
				+ "set cnt_comment = "
					+ "(select count(board_comment.comment_seq)"
					+ "from board_comment"
					+ "where board_seq = #{boardSeq}) "
			+ "where board_seq = #{boardSeq} "
			+ "select cnt_comment as cntComment"
			+ "from board"
			+ "where board_seq = #{boardSeq}" )
	int cntComment(int boardSeq);
	
	@Select(" "
			+ " SELECT "
				+ 	"board_seq as boardSeq, "
				+ 	"title, "
				+ 	"content, "
				+ 	"reg_date as regDate, "
				+	"update_date as updateDate, "
				+ 	"read_count as readCount, "
				+ 	"board.like, "
				+ 	"id, "
				+ " (select count(board_comment.comment_seq) "
				+ "				from board_comment"
				+ "				where board_seq=boardSeq) cntComment "
			+ "FROM "
			+ 	"BOARD "
			+ "ORDER BY "
			+ 	"board.like desc "
			+ "limit 3 ")
	List<BoardDto>selectSortLike();
	
	@Update("update board set board.like=board.like + 1 where board.board_seq=#{boardSeq}")
	int updateLike(int boardSeq);
	
	@Insert(" INSERT INTO BOARD_COMMENT () VALUES( NULL, #{content}, NOW(), #{id}, #{boardSeq} ) ")
	int insertComment(String content, String id, int boardSeq);
	
	
	@Delete(" DELETE FROM BOARD_COMMENT WHERE COMMENT_SEQ=#{commentSeq} ")
	int delComment(int commentSeq);
	
	@Select("select "
			+ "comment_seq as commentSeq, "
			+ "content, "
			+ "reg_date as regDate, "
			+ "id, "
			+ "board_seq as boardSeq "
			+ " from board_comment where board_seq=#{boardSeq} order by reg_date asc")
	List<CommentDto>selectCommentList(int boardSeq);
	
	@Select(" "
			+ " SELECT "
				+ 	"board_seq as boardSeq, "
				+ 	"title, "
				+ 	"content, "
				+ 	"reg_date as regDate, "
				+	"update_date as updateDate, "
				+ 	"read_count as readCount, "
				+ 	"board.like, "
				+ 	"id,"
				+ " (select count(board_comment.comment_seq) "
				+ "				from board_comment"
				+ "				where board_seq=boardSeq) cntComment "
			+ "FROM "
			+ 	"BOARD "
			+ "ORDER BY "
			+ 	"boardSeq asc "
			+ "limit 2 ")
	List<BoardDto>noticeList();

	
	
	
}