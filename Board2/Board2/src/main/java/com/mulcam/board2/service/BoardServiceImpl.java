package com.mulcam.board2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.board2.dao.BoardDAO;
import com.mulcam.board2.dto.Board;
import com.mulcam.board2.dto.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public void regBoard(Board board) throws Exception {
		Integer boardNum = boardDAO.selectMaxBoardNum();
		if(boardNum==null) boardNum = 1;
		else boardNum +=1;
		board.setBoard_num(boardNum);
		board.setBoard_re_ref(boardNum);
		board.setBoard_re_lev(0);
		board.setBoard_re_seq(0);
		board.setBoard_readcount(0);
		boardDAO.insertBoard(board);
	}

	@Override
	public List<Board> getBoardList(int page, PageInfo pageInfo) throws Exception {
		int listCount = boardDAO.selectBoardCount();
		//총 페이지 수. 올림처리
		int maxPage = (int)Math.ceil((double)listCount/10);
		//현재 페이지에 보여줄 시작 페이지 수(1,11,21...)
		int startPage=(((int) ((double)page/10+0.9))-1)*10+1;
		//현재 페이지에 보여줄 마지막 페이지 수(10,20,30...)
		int endPage=startPage+10-1;
		
		if(endPage>maxPage) endPage=maxPage;
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setListCount(listCount);
		int startrow = (page-1)*10+1;
		return boardDAO.selectBoardList(startrow);
	}

}
