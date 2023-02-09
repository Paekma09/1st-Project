package com.boot.jdbc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.jdbc.model.dto.HighlightCommentDto;
import com.boot.jdbc.model.dto.HighlightDto;
import com.boot.jdbc.model.page.PagingVO;


@Mapper
public interface MyBoardMapper {
	
	@Select("SELECT * FROM `HIGHLIGHT` ORDER BY HINO DESC")
	List<HighlightDto>selectList();
	
	@Insert("INSERT INTO `HIGHLIGHT` VALUES(NULL,#{hititle},now(),#{hipath},#{hireadcount})")
	int insert(HighlightDto dto);
	
	@Select("SELECT*FROM `HIGHLIGHT` WHERE HINO=#{hino}")
	HighlightDto selectOne(int hino);
	
	@Update("UPDATE `HIGHLIGHT` SET HITITLE=#{hititle}, HIPATH=#{hipath} WHERE HINO=#{hino}")
	int update(HighlightDto dto);
	
	@Delete("DELETE FROM `HIGHLIGHT` WHERE HINO=#{hino}")
	int delete(int hino);
	
	@Insert(" INSERT INTO HIGHLIGHT_COMMENT () VALUES(#{cono}, #{hino}, #{codetail}, NOW(), #{id}) ")
	int insertComment(HighlightCommentDto dto);
	
	@Select("select CONO, HINO, CODETAIL, CODATE , C.ID, M.NAME FROM HIGHLIGHT_COMMENT C JOIN MEMBER M ON C.ID = M.ID where hino=#{hino} order by CODATE asc")
	List<HighlightCommentDto>selectCommentList(int Hino);
	
	@Update("update HIGHLIGHT set HIREADCOUNT = HIREADCOUNT + 1 where HINO = #{hino}")
	int updateCount(int hino);
	
	@Delete("DELETE FROM `HIGHLIGHT_COMMENT` WHERE HINO=#{hino}")
	int deleteAllComment(int hino);
	
	@Select("SELECT COUNT(*) FROM HIGHLIGHT")
	int countBoard();
	
	@Select("SELECT B.* \r\n"
			+ "		FROM (\r\n"
			+ "			SELECT @rownum := @rownum + 1 RN, A.* \r\n"
			+ "				FROM (\r\n"
			+ "						SELECT h.* \r\n"
			+ "						FROM HIGHLIGHT h, (select @rownum := 0) r\r\n"
			+ "						ORDER BY h.HINO DESC \r\n"
			+ "						) A\r\n"
			+ "				) B\r\n"
			+ "	WHERE B.RN BETWEEN #{start} AND #{end}")
	List<HighlightDto>selectBoard(PagingVO pvo);

	
	@Delete("DELETE FROM `HIGHLIGHT_COMMENT` WHERE CONO=#{cono}")
	int deleteComment(int cono);
	
	@Select( " SELECT COUNT(*) FROM HIGHLIGHT_COMMENT WHERE HINO=#{hino} ")
	int commentCount(int hino);
	
}
