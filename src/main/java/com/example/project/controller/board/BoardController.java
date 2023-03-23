package com.example.project.controller.board;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.model.board.BoardDAO;
import com.example.project.model.board.BoardDTO;
import com.example.project.model.board.PageUtil;
import com.example.project.model.board.ReplyDAO;
import com.example.project.service.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	ReplyDAO replyDao;
	@Autowired
	BoardDAO boardDao;

	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}

	@RequestMapping("insert.do")
	public String insert(BoardDTO dto, HttpSession session) {
		String writer = (String) session.getAttribute("userid");
		/*
		 * String filename = "-";
		 * 
		 * if (!dto.getFile1().isEmpty()) { filename =
		 * dto.getFile1().getOriginalFilename(); try { ServletContext application =
		 * request.getSession().getServletContext(); String path =
		 * application.getRealPath("/WEB-INF/views/images/"); new File(path).mkdir();
		 * dto.getFile1().transferTo(new File(path + filename)); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		
		dto.setWriter(writer);
		boardService.insert(dto);
		return "redirect:/board/list.do";

	}

	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "all") String search_option, @RequestParam(defaultValue = "") String keyword) {
		int count = boardService.count(search_option, keyword);
		PageUtil page_info = new PageUtil(count, curPage);
		int start = page_info.getPageBegin();
		int end = page_info.getPageEnd();
		List<BoardDTO> list = boardService.list(start, end, search_option, keyword);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list");
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("page_info", page_info);
		map.put("count", count);
		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping("detail.do")
	public ModelAndView detail(int idx, int cur_page, String search_option, String keyword, ModelAndView mav, HttpSession session) {
		String userId = (String) session.getAttribute("userid");
		boardService.increase_hit(idx);

		boolean isLiked = boardService.isLiked(idx, userId);
		mav.setViewName("board/view");
		mav.addObject("dto", boardService.detail(idx));
		mav.addObject("count", replyDao.count(idx));
		mav.addObject("cur_page", cur_page);
		mav.addObject("search_option", search_option);
		mav.addObject("keyword", keyword);
		mav.addObject("isLiked", isLiked);
		// mav.addObject("good", ...goodCount('kim',idx)

		return mav;
	}

	@RequestMapping("update.do")
	// public String update(@ModelAttribute BoardDTO dto) {
	public String update(@ModelAttribute BoardDTO dto) {
		
		/*
		 * String filename = "-"; if (dto.getFile1()!=null && !dto.getFile1().isEmpty())
		 * { filename = dto.getFile1().getOriginalFilename(); try { ServletContext
		 * application = request.getSession().getServletContext(); String path
		 * =application.getRealPath("/WEB-INF/views/images/"); new File(path).mkdir();
		 * dto.getFile1().transferTo(new File(path + filename)); } catch (Exception e) {
		 * e.printStackTrace(); } dto.setFilename(filename); } else { BoardDTO dto2
		 * =boardDao.detail(dto.getIdx()); dto.setFilename(dto2.getFilename()); }
		 */
		 boardService.update(dto);
		return "redirect:/board/list.do";
	}
	@RequestMapping("like/{idx}")
	@ResponseBody
	public String boardlike(@PathVariable("idx")int idx, HttpSession session){
		String userId = (String) session.getAttribute("userid");
		String result = boardService.setLike(idx, userId);
		return result;
	}

	@RequestMapping("delete.do")
	public String delete(int idx) {
		System.out.println("idx:"+idx);
		boardService.delete(idx);
		return "redirect:/board/list.do";
	}

	@RequestMapping("list_attach/{idx}")
	@ResponseBody
	public List<String> list_attach(@PathVariable("idx") int idx) {
		return boardService.list_attach(idx);
	}
}
