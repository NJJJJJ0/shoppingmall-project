package com.example.project.controller;


import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.model.member.MemberDAO;
import com.example.project.model.member.MemberDTO;

import com.example.project.model.product.ProductDAO;
import com.example.project.model.product.ProductDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
@Autowired
MemberDAO memberDao;

@RequestMapping("login.do")
	public String login() {
	return "member/login";
}



@RequestMapping("login_check.do")
public ModelAndView login_check(MemberDTO dto, HttpSession session) {
	String name= memberDao.login(dto);
	if(name!=null) {
		session.setAttribute("userid", dto.getUserid());
		session.setAttribute("name", name);
	}
	ModelAndView mav= new ModelAndView();
	if( name != null) {
		mav.setViewName("main");
	} else {
		mav.setViewName("member/login");
		mav.addObject("message","error");
	
	}
	return mav;
}

@RequestMapping("logout.do")
public ModelAndView logout(HttpSession session, ModelAndView mav) {
	session.invalidate();
	mav.setViewName("member/login");
	mav.addObject("message","logout");
	return mav;
}
@Autowired
ProductDAO productDao;
@RequestMapping("member/list.do")
public ModelAndView memberList(ModelAndView mav) {
	List<MemberDTO> list = memberDao.list();
	List<ProductDTO> list2=productDao.list();
	//model.addAttribute("/product/list", list);
	mav.setViewName("/member/list");
	mav.addObject("list",list2);
	mav.addObject("mlist",list);
	//mav.addObject("list2",memberDao.list());
	return mav;
}
	
@RequestMapping("member/write.do")
public String write() {
	return "member/write";
}
@RequestMapping("member/insert.do")
public String insert(@ModelAttribute MemberDTO dto) {
	memberDao.insert(dto);
	return "redirect:/member/login.do";
}

/*
 * @Autowired private MemberService memberService; //아이디 중복체크
 * 
 * @PostMapping("/idCheck")
 * 
 * @ResponseBody public int idCheck(@RequestParam("id") String id) {
 * 
 * int cnt = memberService.idCheck(id); return cnt;
 *//*
	 * }
	 */



@RequestMapping("member/view.do")
public String view(@RequestParam String userid, Model model) {
	model.addAttribute("dto",memberDao.detail(userid));
	return "member/detail";
}
@RequestMapping("member/update.do")
public String update(@ModelAttribute MemberDTO dto, Model model) {
	boolean result = memberDao.check_passwd(dto.getUserid(), dto.getPasswd());
	if(result) { 
		memberDao.update(dto);
		return "redirect:/member/list.do";
	} else {
		MemberDTO dto2 = memberDao.detail(dto.getUserid());
		dto.setJoin_date(dto2.getJoin_date());
		model.addAttribute("dto",dto);
		model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
		return "member/detail";
	}
}
@RequestMapping("member/delete.do")
public String delete(@RequestParam String userid, @RequestParam String passwd, Model model) {
	boolean result =memberDao.check_passwd(userid, passwd);
	if(result) {
		memberDao.delete(userid);
		return "redirect:/member/list.do";
	} else {
		model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
		model.addAttribute("dto",memberDao.detail(userid));
		return "member/detail";
	}
}

}