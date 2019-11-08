package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.BoolResult;
import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.service.MemService;

@RestController
@RequestMapping("/api")
public class RestMemberController {

	@Autowired
	@Qualifier("MemServiceImpl")
	MemService ser;
	
	@PostMapping("/meminsert")
	public ResponseEntity<BoolResult> insert(Member m) {
		ResponseEntity<BoolResult> re = null;
		try {
			ser.insert(m.getId(), m.getPw(), m.getName(), m.getEmail());
			re = new ResponseEntity<BoolResult>(new BoolResult("well done", true, "success"), HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<BoolResult>(new BoolResult("gone wrong", false, "failed"),HttpStatus.NOT_MODIFIED);
		}
		return re;
	}
	@PutMapping("/memupdate")
	public ResponseEntity<BoolResult> update(Member m) {
		ResponseEntity<BoolResult> re = null;
		try {
			ser.update(m.getId(), m.getPw(), m.getName(), m.getEmail());
			re = new ResponseEntity<BoolResult>(new BoolResult("well done", true, "success"), HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<BoolResult>(new BoolResult("gone wrong", false, "failed"),HttpStatus.NOT_MODIFIED);
		}
		return re;
	}
	@DeleteMapping("/memdelete/{id}")
	public ResponseEntity<BoolResult> delete(@PathVariable String id) {
		ResponseEntity<BoolResult> re = null;
		try {
			ser.delete(id);
			re = new ResponseEntity<BoolResult>(new BoolResult("well done", true, "success"), HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<BoolResult>(new BoolResult("gone wrong", false, "failed"),HttpStatus.NOT_MODIFIED);
		}
		return re;
	}
	@GetMapping("/memselone/{id}")
	public ResponseEntity selectOne(@PathVariable String id) {
		//입력처리

		//로직처리
		ResponseEntity re = null;
		Member m;
		try {
			m = ser.selectOne(id);
			re = new ResponseEntity<Member>(m, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<BoolResult>(new BoolResult("gone wrong", false, "failed"), HttpStatus.NO_CONTENT);
		}
		//결과처리
		return re;
	}
	@GetMapping("/memsellist")
	public ResponseEntity selectList(HttpServletRequest req, ModelAndView mv) {
		//입력처리
		
		//로직처리
		ResponseEntity re = null;
		try {
			List<Member> list = ser.selectList();
			re = new ResponseEntity<List<Member>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<BoolResult>(new BoolResult("gone wrong", false, "failed"), HttpStatus.NO_CONTENT);
		}
		//결과처리
		
		return re;
	}
}
