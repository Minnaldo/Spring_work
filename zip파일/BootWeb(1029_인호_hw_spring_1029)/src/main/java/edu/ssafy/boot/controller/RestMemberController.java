package edu.ssafy.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.boot.dto.BoolResult;
import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.service.MemService;

//@Controller
@RestController
@RequestMapping(value="/api")
public class RestMemberController {
	
	@Autowired
	@Qualifier("MemServiceImpl")
	MemService ms;
	
	@PostMapping("/meminsert")
	public ResponseEntity<String> insert(@RequestBody Member mem) {
		ResponseEntity<String> re = null;
		try {
			ms.insert(mem.getId(), mem.getPw(), mem.getName(), mem.getEmail());
			re = new ResponseEntity<String>("등록 성공", HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity<String>("등록 실패", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@PutMapping("/memupdate")
	public ResponseEntity<String> update(@RequestBody Member mem) {
		ResponseEntity<String> re = null;
		try {
			ms.update(mem.getId(), mem.getPw(), mem.getName(), mem.getEmail());
			re = new ResponseEntity<String>("수정 성공", HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity<String>("수정 실패", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@DeleteMapping("/memdelete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		ResponseEntity<String> re = null;
		try {
			ms.delete(id);
			re = new ResponseEntity<String>("삭제 성공", HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity<String>("삭제 실패", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@GetMapping("/memselectone/{id}")
	public ResponseEntity<Member> selectone(@PathVariable String id) {
		ResponseEntity<Member> re = null;
		try {
			Member m = ms.selectOne(id);
			re = new ResponseEntity<Member>(m, HttpStatus.OK);
		}catch(Exception e) {
			re = new ResponseEntity("조회 실패", HttpStatus.NO_CONTENT);
		}
		return re;
	}

	@GetMapping("/memselectall")
	public ResponseEntity<List<Member>> selectAll() {
		ResponseEntity<List<Member>> re = null;
		try {
			List<Member> list = ms.selectAll();
			re = new ResponseEntity<List<Member>>(list, HttpStatus.OK);
		}catch(Exception e){
			re = new ResponseEntity("목록 조회 실패", HttpStatus.NO_CONTENT);
		}
		return re;
	}
}