package com.mulcam.board2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.board2.dto.Board;

@Mapper
@Repository
public interface BoardDAO {
	Integer selectMaxBoardNum() throws Exception;
	void insertBoard(Board board) throws Exception;
	int selectBoardCount() throws Exception;
	List<Board> selectBoardList(int startrow) throws Exception;
}
