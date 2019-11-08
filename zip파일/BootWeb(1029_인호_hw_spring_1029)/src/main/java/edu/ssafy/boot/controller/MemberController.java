package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.service.MemService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	/*
	 * @GetMapping("/")
	 * @PutMapping("/")
	 * @PostMapping("/")
	 * @DeleteMapping("/")
	 */
	@RequestMapping(value= {"/", "index"})
	public String home() {
		return "index";
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

		try {//예외처리
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String email = req.getParameter("email");

			//list.add(new Member(id, pw, name, email));
			ms.insert(id, pw, name, email);
			List<Member> list = ms.selectAll();

			mv.addObject("list", list);
			mv.setViewName("redirect:memselectall");
		}catch(Exception e){
			mv.setViewName("myerror");
		}
		
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
		mv.setViewName("redirect:memselectall");
		return mv;
	}

	@RequestMapping("/memdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {

		String id = req.getParameter("id");
		//입력처리

		ms.delete(id);
		List<Member> list = ms.selectAll();

		mv.addObject("list", list);
		mv.setViewName("redirect:memselectall");
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

	@ExceptionHandler(Exception.class)
	public String exceptionMethod(Exception e, Model m){
		e.printStackTrace();
		m.addAttribute("exception", e);
		return "myerror";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(pw.equals(ms.selectOne(id).getPw())) {
			HttpSession ss = req.getSession();
			ss.setAttribute("id", id);
			mv.addObject("id", id);
		}
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req, ModelAndView mv) {
		HttpSession ss = req.getSession();
		ss.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	}
}