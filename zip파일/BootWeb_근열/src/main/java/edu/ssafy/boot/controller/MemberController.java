package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.exception.MyException;
import edu.ssafy.boot.service.MemService;

@Controller
public class MemberController {

//	@RequestMapping(value= {"/","index"})
	@GetMapping("/") //get만 접근 가능한 매핑
	public String home() {
		return "index";
	}
//	@PutMapping
//	@PostMapping
//	@DeleteMapping //4.3부터 지원되는 기능들

	@ExceptionHandler(MyException.class)
	public String myExceptionMethod(MyException e) {
		e.trace();
		return "myerror";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionMethod(Exception e, Model m) {
		e.printStackTrace();
		m.addAttribute("exception", e);
		return "myerror";
	}
	
	
	@Autowired
	@Qualifier("MemServiceImpl")
	MemService ser;
	
	@RequestMapping("memregpage")
	public ModelAndView insertPage(ModelAndView mv) {
		mv.setViewName("member/memreg");
		return mv;
	}
	@RequestMapping("/meminsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		try {
			//입력처리
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			//로직처리
			ser.insert(id, pw, name, email);
		} catch (Exception e) {
			// TODO: handle exception
//			exceptionMethod(e, (Model) mv.getModel());
		} finally {
			// TODO: handle finally clause
		}
		//결과처리
		List<Member> list = ser.selectList();			

		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		return mv;
	}
	@RequestMapping("/memupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {
		//입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		//로직처리
		ser.update(id, pw, name, email);
		//결과처리
		List<Member> list = ser.selectList();
		
		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		
		return mv;
	}
	@RequestMapping("/memdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {
		//입력처리
		String id = req.getParameter("id");
		//로직처리
		ser.delete(id);
		//결과처리
		List<Member> list = ser.selectList();
		
		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		
		return mv;
	}
	@RequestMapping("/memselone")
	public ModelAndView selectOne(HttpServletRequest req, ModelAndView mv) {
		//입력처리
		String id = req.getParameter("id");
		//로직처리
		Member m = ser.selectOne(id);
		//결과처리
		mv.addObject("mem", m);
		mv.setViewName("member/memview");
		return mv;
	}
	@RequestMapping("/memsellist")
	public ModelAndView selectList(HttpServletRequest req, ModelAndView mv) {
		//입력처리
		
		//로직처리
		List<Member> list = ser.selectList();
		//결과처리
		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		
		return mv;
	}
}
