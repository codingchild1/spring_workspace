package com.mulcam.Board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mulcam.Board.dto.Board;
import com.mulcam.Board.dto.PageInfo;

@Service
public interface BoardService {
	void regBoard(Board board) throws Exception;
	List<Board> getBoardList(int page, PageInfo pageInfo) throws Exception;
	Board getBoard(int boardNum) throws Exception;
	void regReply(Board board)throws Exception;
	void modifyBoard(Board board)throws Exception;
	void removeBoard(int boardNum, String boardPass)throws Exception;
}
