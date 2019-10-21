package edu.ssafy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Member;

@Controller
@RequestMapping(value="/member")
public class MemberController {		//위에 RequestMapping 으로  내가 memeber로 쓰면 이걸 띄우겠다.
	
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
		
		//결과처리
		ArrayList<Member> list = new ArrayList();
		list.add(new Member(id, null, name, email));
		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		return mv;
	}
}
