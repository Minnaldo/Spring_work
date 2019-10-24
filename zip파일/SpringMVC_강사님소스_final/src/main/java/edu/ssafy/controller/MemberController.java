package edu.ssafy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Member;
import edu.ssafy.exception.MyException;
import edu.ssafy.service.MemService;

@Controller
public class MemberController {
	@ExceptionHandler(MyException.class)
	public String myExceptionMethod(MyException e) {
		e.trace();
		return "myerror";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionMethod(Exception e, Model m) {
		e.printStackTrace();
		System.out.println("aaaaaaaaaaaaaaaaa");
		m.addAttribute("exception",e);
		return "myerror";
	}
	
	@Autowired
	@Qualifier("MemServiceImpl")
	private MemService ser;

	@RequestMapping("/memregpage")
	public ModelAndView insertPage(ModelAndView mv) {
		mv.setViewName("member/memreg");
		return mv;
	}

	@RequestMapping("/meminsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		// 로직처리
		ser.insert(id, pw, name, email);
		// 결과처리
		mv.setViewName("redirect:memselectlist");
		return mv;
	}

	@RequestMapping("/memupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		// 로직처리
		ser.update(id,pw,name,email);
		// 화면처리
		mv.setViewName("redirect:memselectlist");
		return mv;
	}

	@RequestMapping("/memdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		ser.delete(id);
		// 화면처리
		mv.setViewName("redirect:memselectlist");
		return mv;
	}

	@RequestMapping("/memselectone")
	public ModelAndView selectOne(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		Member selectOne = ser.selectOne(id);
		// 화면처리
		mv.addObject("mem", selectOne);
		mv.setViewName("member/memview");
		return mv;
	}

	@RequestMapping("/memselectlist")
	public ModelAndView selectList(HttpServletRequest req, ModelAndView mv) {
		List<Member> list = ser.selectList();
		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		
		return mv;
	}
}
