
package edu.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ssafy.dto.BoardDTO;
import edu.ssafy.service.BoardService;

@Controller
public class BoardController {

	@ExceptionHandler(Exception.class)
	public String boardException(Model m, Exception e) {
		m.addAttribute("errortitle", e.getMessage());
		m.addAttribute("errorcontent", e.getStackTrace());
		return "errorpage";
	}

	@Autowired
	private BoardService svc;

	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("message", "메인 페이지입니다");
		return "index";
	}

	@RequestMapping("/boardinsert")
	public String redInsert() {
		return "boardinsert";
	}

	// 어노테이션으로 값을 가져오는 방법

	@RequestMapping("/boardinsertpage")
	public String boardinsertpage(Model m, BoardDTO b, @RequestParam(name = "num") String num) throws Exception {
		svc.insert(b);
		m.addAttribute("message", "성공적으로 등록되었습니다.");
		return "redirect:boardlist";
	}

	@RequestMapping("/boardprintpage")
	public String boardprintpage(Model m, BoardDTO b) throws Exception {
		m.addAttribute("board", svc.select(b));
		m.addAttribute("message", "홈페이지입니다");
		return "redirect:boardview";
	}

	@RequestMapping("/boardlistpage")
	public String boardlistpage(Model m, BoardDTO b) throws Exception {
		m.addAttribute("list", svc.selectAll());
		m.addAttribute("message", "홈페이지입니다");
		return "redirect:boardlist";
	}
}
