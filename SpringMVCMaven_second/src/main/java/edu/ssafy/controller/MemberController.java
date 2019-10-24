package edu.ssafy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Member;
import edu.ssafy.exception.MyException;
import edu.ssafy.service.MemService;

@Controller
@RequestMapping(value="/member")
public class MemberController {		//위에 RequestMapping 으로  내가 memeber로 쓰면 이걸 띄우겠다.
	
	@ExceptionHandler(MyException.class)
    public String myExceptionMethod(MyException e) {
        e.trace();
        return "myerror";
    }
    
    @ExceptionHandler(Exception.class)
    public String exceptionMethod(Exception e) {
        e.printStackTrace();
        return "myerror";
    }
	
	
	@Autowired
	@Qualifier(value="MemServiceImpl")
	MemService ser;
	
	@RequestMapping(value="/memregpage")
	public ModelAndView insertPage(ModelAndView mv) {
		//forward로 불렀다는 거임.		//WEB-INF 아래 있는애들은 직접적(강제로) 호출할 수 없다.
		mv.setViewName("member/memreg");
		return mv;
	}
	
	@RequestMapping(value="/meminsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		//입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		//로직처리
		ser.insert(id, pw, name, email);
		//결과처리
		List<Member> list = ser.selectList();
		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		
//		mv.setViewName("redirect:memselectlist");
		return mv;
	}
	
	@RequestMapping("/memupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {
		
		//입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		//로직 처리
		List<Member> list = ser.selectList();
		mv.addObject("list",list);
		ser.update(id, pw, name, email);		
		//결과처리
		mv.setViewName("member/memlist");
		
//		mv.setViewName("redirect:memselectlist");

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
		mv.addObject("list",list);
		mv.setViewName("member/memlist");	
		
//		mv.setViewName("redirect:memselectlist");
		return mv;
	}
	
	
	@RequestMapping("/memselectone")
	public ModelAndView selectone(HttpServletRequest req, ModelAndView mv) {
		//입력처리
		String id = req.getParameter("id");
		Member selectone = ser.selectone(id);
		//로직처리
		mv.addObject("mem", selectone);
		mv.setViewName("member/memview");
		//결과처리
		return mv;
	}
	
	@RequestMapping("/memselectlist")
	public ModelAndView selectlist(HttpServletRequest req, ModelAndView mv) {
		//입력처리
		//로직처리
		List<Member> list = ser.selectList();	
		//결과처리
		mv.addObject("list",list);
		mv.setViewName("member/memlist");

		return mv;
	}
//	
	
	
	
}







