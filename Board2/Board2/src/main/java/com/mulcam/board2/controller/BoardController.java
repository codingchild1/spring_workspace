package com.mulcam.board2.controller;

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

import com.mulcam.board2.dto.Board;
import com.mulcam.board2.dto.PageInfo;
import com.mulcam.board2.service.BoardService;

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
	
}
