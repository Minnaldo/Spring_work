package edu.ssafy.food.controller;

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
import edu.ssafy.food.dto.MemVO;
import edu.ssafy.food.service.MemService;

@RestController
@RequestMapping("/api")
public class RestSafeController {

	@Autowired
	@Qualifier("MemServiceImpl")
	MemService ser;

	
	
	@PostMapping("/signUp")
	public ResponseEntity insert(MemVO mem) {
		ResponseEntity re = null;
		try {
			ser.addMem(mem.getId(), mem.getPw(), mem.getName(),mem.getAddr(), mem.getEmail(),mem.getTel(),mem.getAlinfo());
			re = new ResponseEntity("잘들어갔어요", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("입력실패했어요", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@PutMapping("/memupdate")
	public ResponseEntity<String> update(MemVO mem) {
		ResponseEntity re = null;
		try {
			ser.updateMem(mem.getId(), mem.getPw(), mem.getName(),mem.getAddr(), mem.getEmail(),mem.getTel(),mem.getAlinfo());
			re = new ResponseEntity<String>("잘수정되었어요", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("수정실패했어요", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@DeleteMapping("/memdelete/{id}")
	public ResponseEntity delete(@PathVariable String id) {
		ResponseEntity re = null;
		try {
			ser.delMem(id);
			re = new ResponseEntity<String>("잘삭제되었어요", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제실패했어요", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@GetMapping("/memselone/{id}")
	public ResponseEntity<MemVO> selectOne(@PathVariable String id) {
		ResponseEntity<MemVO> re = null;
		try {
			MemVO selectOne = ser.selectOne(id);
			re = new ResponseEntity<MemVO>(selectOne, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회실패했어요", HttpStatus.NO_CONTENT);
		}
		return re;
	}

	@GetMapping("/memsellist")
	public ResponseEntity<List<MemVO>> selectList() {
		System.out.println("");
		ResponseEntity<List<MemVO>> re = null;
		try {
			List<MemVO> list = ser.selectList();
			re = new ResponseEntity<List<MemVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회실패했어요", HttpStatus.NO_CONTENT);
		}
		return re;
	}
	
	@GetMapping("/login/{id}/{pw}")
	public ResponseEntity<MemVO> login(@PathVariable String id,@PathVariable String pw) {
		ResponseEntity<MemVO> re = null;
		try {
			MemVO log = ser.login(id, pw);
			re = new ResponseEntity<MemVO>(log, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("로그인실패했어요", HttpStatus.NO_CONTENT);
		}
		return re;
	}
	
	@GetMapping("/main")
	public String Main() {
		return "main";
	}
	
	@GetMapping("/pdetail")
	public void Pdetail() {
	}
	
	@GetMapping("/productInfo")
	public void ProductInfo() {
	}
	
	@GetMapping("/Logout")
	public void Logout() {
	}
	
	@GetMapping("/searchProduct")
	public void searchProduct() {
	}
	
	@GetMapping("/date")
	public void date() {
	}
	
	@GetMapping("/calo")
	public void calo() {
	}
	
	@GetMapping("/searchpw")
	public void searchpw() {
	}
	
	@GetMapping("/shoppingbox")
	public void shoppingbox() {
	}
	
	
	
}
