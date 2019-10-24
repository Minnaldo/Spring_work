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
@RequestMapping(value="/member")
public class MemberController {
	
	@ExceptionHandler(MyException.class)
	public String myExceptionMethod(MyException e){
		e.trace();
		return "myerror";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionMethod(Exception e, Model m){
		e.printStackTrace();
		m.addAttribute("exception", e);
		return "myerror";
	}
	
	@Autowired
	@Qualifier("MemServiceImpl")
	MemService ms;

	@RequestMapping("/memregpage")
	public ModelAndView insertPage(ModelAndView mv) {
		mv.setViewName("member/memreg");
		return mv;
	}
	@RequestMapping("/meminsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		//list.add(new Member(id, pw, name, email));
		ms.insert(id, pw, name, email);
		List<Member> list = ms.selectAll();
		
		mv.addObject("list", list);
		mv.setViewName("/member/memlist");
		 
		return mv;
	}
	@RequestMapping("/memselectone")
	public ModelAndView selectone(HttpServletRequest req, ModelAndView mv) {

		String id = req.getParameter("id");
		Member m = ms.selectOne(id);
		
		mv.addObject("mem", m);
		mv.setViewName("/member/memview");
		return mv;
	}

	@RequestMapping("/memselectall")
	public ModelAndView selectAll(HttpServletRequest req, ModelAndView mv) {
		
		List<Member> list = ms.selectAll();
		
		mv.addObject("list", list);
		mv.setViewName("/member/memlist");
		return mv;
	}
	
	@RequestMapping("/memupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		//입력처리
		ms.update(id, pw, name, email);
		List<Member> list = ms.selectAll();
		
		mv.addObject("list", list);
		mv.setViewName("/member/memlist");
		return mv;
	}
	@RequestMapping("/memdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {

		String id = req.getParameter("id");
		//입력처리
		
		ms.delete(id);
		List<Member> list = ms.selectAll();
		
		mv.addObject("list", list);
		mv.setViewName("/member/memlist");
		return mv;
	}

}