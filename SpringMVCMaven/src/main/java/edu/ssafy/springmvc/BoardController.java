package edu.ssafy.springmvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.exception.MyException;
import edu.ssafy.service.BoardService;
import edu.ssafy.util.BoardDto;

@Controller
public class BoardController {

	@ExceptionHandler(MyException.class)
	public String myException(MyException e) {
		return "errorpage";
	}
	
	@Autowired
	private BoardService ser;
	
	@RequestMapping(value= {"/", "index"})
	public String index() {
		
		return "index";
	}
	
//	@RequestMapping(value="insertpage")
	@RequestMapping("boardregpage")
	public String insertPage() {
		
		return "board/boardreg";
	}
	
	@RequestMapping("boardreg")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		ser.insert(no, title, content);
		mv.setViewName("redirect:boardlist");
		return mv;
	}
	
	@RequestMapping("boardlist")
	public ModelAndView selectList(ModelAndView mv) {
		List<BoardDto> list = ser.selectlist();
		mv.setViewName("board/boardlist");		//얘는 jsp boardlist.jsp 파일
		mv.addObject("list", list);
		return mv; 
	}
}
