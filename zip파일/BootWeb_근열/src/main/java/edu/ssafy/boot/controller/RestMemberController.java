package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.service.MemService;
import io.swagger.annotations.ApiOperation;

@RestController
public class RestMemberController {
	
	 @Autowired
	    MemService ser;
	    
	    //@Autowired
	    //BoardDto dd;
	    
	 	@RequestMapping("/memregpage")
	    public ModelAndView insertPage(ModelAndView mv) {
	        mv.setViewName("redirect:member/memreg");
	        return mv;
	    }
	 
	    @PostMapping(value="/meminsert")
	    public void insert(Member mem) {
	    	ser.insert(mem.getId(), mem.getPw(), mem.getName(), mem.getEmail());
	        
	        
	    }
	    
	    
	    @PutMapping(value="/memupdate")
	    public void update(Member mem) {
	    	ser.update(mem.getId(), mem.getPw(), mem.getName(), mem.getEmail());
	        
	        
	    }
	    
	    @DeleteMapping(value="/memdelete/{id}")
	    public void delete(@PathVariable String id) {
	    	ser.delete(id);
	        
	    }
	    
	    @GetMapping(value="/memselone/{id}")
	    public Member selectOne(@PathVariable String id) {
	    	Member m = ser.selectOne(id);
	    	
	    	return m;
	        
	    }
	    
	    @GetMapping(value="/memsellist")
	    public List<Member> selectList(HttpServletRequest req, ModelAndView m){
	    	
	    	List<Member> selectList = ser.selectList();
	    	
	    	return selectList;
	    }
}
