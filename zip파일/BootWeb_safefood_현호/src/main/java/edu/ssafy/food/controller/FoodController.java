package edu.ssafy.food.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.food.dto.MemVO;
import edu.ssafy.food.service.MemService;

@Controller
public class FoodController {
	
	@Autowired
	@Qualifier("MemServiceImpl")
	MemService ser;
	
	@GetMapping("/") // get만 접근 가능한 매핑
	public String home() {
		return "main";
	}
	
	@PostMapping("/signUp")
	public ModelAndView insert(HttpServletRequest request, ModelAndView mv) {
		try {
			// 입력처리
			
			String id = request.getParameter("pid");
	        String pw = request.getParameter("ppw1");
	        String pw2 = request.getParameter("ppw2");
	        String name = request.getParameter("pname");
	        String addr = request.getParameter("paddr");
	        String email1=request.getParameter("pemail1");
	        String email2=request.getParameter("pemail2");
	        System.out.println(id);
	        String email=email1+"@"+email2;
	        
	        String tel1=request.getParameter("ptel1");
	        String tel2=request.getParameter("ptel2");
	        String tel3=request.getParameter("ptel3");
	        
	        String tel=tel1+"-"+tel2+"-"+tel3;
	        
	        String[] value = request.getParameterValues("hobby");

	        String alinfo = "";
	        for(String tmp : value) {
	        	alinfo += tmp + ",";
	        }
	        
//			String id = req.getParameter("id");
//			String pw = req.getParameter("pw");
//			String name = req.getParameter("name");
//			String email = req.getParameter("email");
			// 로직처리
			ser.addMem(id, pw, name, addr,email,tel,alinfo);
			System.out.println(id+" "+pw);
		} catch (Exception e) {
			// TODO: handle exception
//			exceptionMethod(e, (Model) mv.getModel());
		} finally {
			// TODO: handle finally clause
		}
		// 결과처리
//		List<MemVO> list = ser.selectList();

//		mv.addObject("list", list);
		mv.setViewName("main");
		
		return mv;
	}
}
