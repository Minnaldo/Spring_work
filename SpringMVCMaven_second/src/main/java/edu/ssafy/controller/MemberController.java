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
	
	ArrayList<Member> list = new ArrayList<Member>();
	
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
		
		list.add(new Member(id, null, name, email));
		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		return mv;
	}
	
	@RequestMapping("/memupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		//�Է�ó��
		for (Member m : list) {
			if(m.getId().equals(id)) {
				m.setName(name);
				m.setPw(pw);
				m.setEmail(email);
				break;
			}
		}
		
		mv.addObject("list",list);
		mv.setViewName("member/memlist");

		return mv;
	}
	
	@RequestMapping("/memdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {
		
		String id = req.getParameter("id");
		//�Է�ó��
		for (Member m : list) {
			if(m.getId().equals(id)) {
				list.remove(m);
				break;
			}
		}
		mv.addObject("list",list);
		mv.setViewName("member/memlist");
		
		return mv;
	}
	
	
	@RequestMapping("/memselectone")
	public ModelAndView selectone(HttpServletRequest req, ModelAndView mv) {
		
		String id = req.getParameter("id");
		ArrayList<Member> meminfo = new ArrayList<Member>();
		//�Է�ó��
		for (Member m : list) {
			if(m.getId().equals(id)) {
				meminfo.add(m);
				break;
			}
		}
		
		mv.addObject("list",meminfo);
		mv.setViewName("member/memlist");

		return mv;
	}
	
	@RequestMapping("/memselectall")
	public ModelAndView selectAll(HttpServletRequest req, ModelAndView mv) {
		mv.addObject("list",list);
		mv.setViewName("member/memlist");

		return mv;
	}
//	
	
	
	
}






//@RequestMapping(value="/memupdate")
//public void update(Member mb) {
//	for (int i = 0; i < list.size(); i++) {
//		if(list.get(i).getId().equals(mb.getId())) {
//			list.set(i, mb);
//		}
//	}
//}

//@RequestMapping(value="/memdelete")
//public void delete(String id) {
//	for(int i = 0; i < list.size(); i++) {
//		if(list.get(i).getId().equals(id)) {
//			list.remove(i);
//		}
//	}
//}
