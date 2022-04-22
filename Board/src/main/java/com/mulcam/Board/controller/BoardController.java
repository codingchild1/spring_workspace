package com.mulcam.Board.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.Board.dto.Board;
import com.mulcam.Board.dto.PageInfo;
import com.mulcam.Board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	@PostMapping("boardwrite")
	public ModelAndView boardWrite(@ModelAttribute Board board) {
		ModelAndView mv = new ModelAndView();
		try {
			if(!board.getFile().isEmpty() ) { //파일 첨부시 파일 업로드
				String path = servletContext.getRealPath("/boardupload/");
				File destFile = new File(path+board.getFile().getOriginalFilename());
				board.setBoard_filename(board.getFile().getOriginalFilename());
				board.getFile().transferTo(destFile);
			}
			boardService.regBoard(board);
			mv.setViewName("redirect:/board/boardlist");
		} catch(Exception e) {
			e.printStackTrace();
			mv.addObject("err", "새글 등록 실패");
			mv.setViewName("/board/err");
		}
		return mv;
	}	
	
	@RequestMapping(value="/boardlist", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardList(@RequestParam(value="page",required=false, defaultValue = "1") int page) {
		ModelAndView mv = new ModelAndView();
		PageInfo pageInfo = new PageInfo();
		try {
			List<Board> articleList = boardService.getBoardList(page, pageInfo);
			mv.addObject("pageInfo", pageInfo);
			mv.addObject("articleList", articleList);
			mv.setViewName("/board/listform");
		} catch(Exception e) {
			e.printStackTrace();
			mv.addObject("err", e.getMessage());
			mv.setViewName("/board/err");
		}
		
		return mv;
	}
	
	@GetMapping(value="/boarddetail")
	public ModelAndView boardDetail(@RequestParam(value="board_num") int boardNum, 
			@RequestParam(value="page", required = false, defaultValue = "1") int page) {
		ModelAndView mv = new ModelAndView();
		try {
			Board board = boardService.getBoard(boardNum);
			mv.addObject("article", board);
			mv.addObject("page", page);
			mv.setViewName("/board/viewform");
		} catch(Exception e) {
			e.printStackTrace();
			mv.addObject("err", e.getMessage());
			mv.setViewName("/board/err");
		}		
		return mv;
	}
	
	@GetMapping(value="/replyform")
	public ModelAndView replyform(@RequestParam(value="board_num") int boardNum, 
			@RequestParam(value="page") int page) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("page", page);
		mv.addObject("boardNum", boardNum);
		mv.setViewName("/board/replyform");
		return mv;
	}
	
	@PostMapping(value="/boardreply")
	public ModelAndView boardreply(@ModelAttribute Board board, @RequestParam(value="page") int page) {
		ModelAndView mv = new ModelAndView();
		try {
			boardService.regReply(board);
			mv.addObject("page",page);
			mv.setViewName("redirect:/board/boardlist");
		} catch(Exception e) {
			e.printStackTrace();
			mv.addObject("err", e.getMessage());
			mv.setViewName("/board/err");
		}
		return mv;
	}
	
	@GetMapping(value="/modifyform")
	public ModelAndView modifyform(@RequestParam(value="board_num") int boardNum) {
		ModelAndView mv = new ModelAndView();
		try {
			Board board = boardService.getBoard(boardNum);
			mv.addObject("article", board);
			mv.setViewName("/board/modifyform");
		} catch(Exception e) {
			e.printStackTrace();
			mv.addObject("err", e.getMessage());
			mv.setViewName("/board/err");
		}
		
		return mv;
	}
	
	@PostMapping(value="/boardmodify")
	public ModelAndView boardmodify(@ModelAttribute Board board) {
		ModelAndView mv = new ModelAndView();
		try {
			boardService.modifyBoard(board);
			mv.addObject("board_num", board.getBoard_num());
			mv.setViewName("redirect:/board/boarddetail");
		} catch(Exception e) {
			e.printStackTrace();
			mv.addObject("err", e.getMessage());
			mv.setViewName("/board/err");	
		}
		
		return mv;
	}
	
	@GetMapping(value="/deleteform")
	public ModelAndView deleteform(@RequestParam(value="board_num") int boardNum,
			@RequestParam(value="page", required=false, defaultValue = "1") int page) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board_num", boardNum);
		mv.addObject("page", page);
		mv.setViewName("/board/deleteform");
		return mv;
	}
	
	@PostMapping(value="/boarddelete")
	public ModelAndView boarddelete(@RequestParam(value="board_num") int boardNum,
			@RequestParam(value="board_pass") String boardPass,
			@RequestParam(value="page", required=false, defaultValue = "1") int page) {
		ModelAndView mv = new ModelAndView();
		try {
			boardService.removeBoard(boardNum, boardPass);
			mv.addObject("page", page);
			mv.setViewName("redirect:/board/boardlist");
		} catch(Exception e) {
			e.printStackTrace();
			mv.addObject("err", e.getMessage());
			mv.setViewName("/board/err");	
		}
		return mv;
	}
}
