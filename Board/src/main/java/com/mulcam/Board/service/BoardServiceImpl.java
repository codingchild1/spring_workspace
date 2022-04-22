package com.mulcam.Board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mulcam.Board.dao.BoardDAO;
import com.mulcam.Board.dto.Board;
import com.mulcam.Board.dto.PageInfo;

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
		//총 페이지 수 올림처리
		int maxPage = (int)Math.ceil((double)listCount/10);
		//현재 페이지에 보여줄 시작 페이지 수 (1,11,21...)
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
	@Override
	public Board getBoard(int boardNum) throws Exception {
		boardDAO.updateReadCount(boardNum);
		return boardDAO.selectBoard(boardNum);
	}
	@Override
	public void regReply(Board board) throws Exception {
		//1. board_num으로 원글 조회
		Board src_board = boardDAO.selectBoard(board.getBoard_num());
		//2. 글번호를 새로 생성해서 할당
		Integer boardNum = boardDAO.selectMaxBoardNum();
		board.setBoard_num(boardNum+1);
		//3. 원글의 ref번호로 답글. ref번호 할당
		board.setBoard_re_ref(src_board.getBoard_re_ref());
		//4. 원글의 lev에 1을 더하여 lev 할당
		board.setBoard_re_lev(src_board.getBoard_re_lev()+1);
		//5. 원글의 seq보다 큰 seq인 글들을 +1
		boardDAO.updateBoardReSeq(src_board);
		//6. 원글의 seq에 1을 더하여 seq 할당
		board.setBoard_re_seq(src_board.getBoard_re_ref()+1);
		boardDAO.insertBoard(board);
	}
	@Override
	public void modifyBoard(Board board) throws Exception {
		//1.입력된 비밀번호가 원본의 비밀번호와 같은지 체크
		String password = boardDAO.selectPassword(board.getBoard_num());
		//2.비밀번호가 같으면, 글내용 수정
		if(password.equals(board.getBoard_pass())) {
			boardDAO.updateBoard(board);
		}else { //3.비밀번호가 다르면 권한없음 예외
			throw new Exception("수정 권한 없음");
		}
	}
	@Override
	public void removeBoard(int boardNum, String boardPass) throws Exception {
		String password = boardDAO.selectPassword(boardNum);
		if(password.equals(password)) {
			boardDAO.deleteBoard(boardNum);
		}else { //3.비밀번호가 다르면 권한없음 예외
			throw new Exception("수정 권한 없음");
		
	}
	
	}
	

}
