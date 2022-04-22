package com.mulcam.board2.service;

import java.util.List;

import com.mulcam.board2.dto.Board;
import com.mulcam.board2.dto.PageInfo;

public interface BoardService {
	void regBoard(Board board) throws Exception;
	List<Board> getBoardList(int page, PageInfo pageInfo) throws Exception;
}
