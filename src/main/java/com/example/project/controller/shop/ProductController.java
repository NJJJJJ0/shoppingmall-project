package com.example.project.controller.shop;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.model.board.BoardDTO;
import com.example.project.model.board.PageUtil;
import com.example.project.model.product.ProductDAO;
import com.example.project.model.product.ProductDTO;
import com.example.project.service.board.BoardService;

@Controller
@RequestMapping("product/product/*")
public class ProductController {
	@Autowired
	ProductDAO productDao;

	@RequestMapping("write.do")
	public String write() {
		return "product/product_write";
	}

	@RequestMapping("insert.do")
	public String insert(ProductDTO dto, HttpServletRequest request) {
		String filename = "-";
		if (!dto.getFile1().isEmpty()) {
			filename = dto.getFile1().getOriginalFilename();
			try {
				ServletContext application = request.getSession().getServletContext();
				String path = application.getRealPath("/WEB-INF/views/images/");
				new File(path).mkdir();
				dto.getFile1().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setFilename(filename);
		productDao.insert(dto);
		return "redirect:/member/list.do";
	}

	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/product/product_list");
		mav.addObject("list", productDao.list());
		return mav;

	}

	@RequestMapping("edit/{product_code}")
	public ModelAndView edit(@PathVariable("product_code") int product_Code, ModelAndView mav) {
		mav.setViewName("/product/product_edit");
		mav.addObject("dto", productDao.detail(product_Code));
		return mav;
	}

	@RequestMapping("update.do")
	public String update(ProductDTO dto, HttpServletRequest request) {
		String filename = "-";
		if (!dto.getFile1().isEmpty()) {
			filename = dto.getFile1().getOriginalFilename();
			try {
				ServletContext application = request.getSession().getServletContext();
				String path = application.getRealPath("/WEB-INF/views/images/");
				new File(path).mkdir();
				dto.getFile1().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setFilename(filename);
		} else {
			ProductDTO dto2 = productDao.detail(dto.getProduct_code());
			dto.setFilename(dto2.getFilename());
		}
		productDao.update(dto);
		return "redirect:/shop/product/list.do";
	}

	@RequestMapping("delete.do")
	public String delete(int product_code, HttpServletRequest request) {
		String filename = productDao.file_info(product_code);
		if (filename != null && !filename.equals("-")) {
			ServletContext application = request.getSession().getServletContext();
			String path = application.getRealPath("/WEB-INF/views/images/");
			File f = new File(path + filename);
			if (f.exists())
				f.delete();
		}
		productDao.delete(product_code);
		return "redirect:/shop/product/list.do";
	}

	@Autowired
	BoardService boardService;
	
	@RequestMapping("detail/{product_code}")
	public ModelAndView detail(@PathVariable int product_code, ModelAndView mav) {
		mav.setViewName("/product/product_detail");
		mav.addObject("dto", productDao.detail(product_code));
		return mav;
	}
	@RequestMapping("list1.do")
	public ModelAndView list(@RequestParam(defaultValue ="1")int curPage,
			@RequestParam(defaultValue = "all") String search_option,
			@RequestParam(defaultValue ="") String keyword) {
		int count = boardService.count(search_option, keyword);
		PageUtil page_info = new PageUtil(count,curPage);
		int start = page_info.getPageBegin();
		int end = page_info.getPageEnd();
		List<BoardDTO> list = boardService.list(start, end, search_option, keyword);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list");
		Map<String, Object>map =new HashMap<>();
		map.put("list",list);
		map.put("search_option", search_option);
		map.put("keyword",keyword);
		map.put("page_info", page_info);
		mav.addObject("map", map);
		return mav;
	}
	
	
	
}

















