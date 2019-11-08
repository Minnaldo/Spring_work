package edu.ssafy.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.ApplicationScope;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;
import edu.ssafy.service.BoardService;
import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/api")
public class RestBoardController {
    @Autowired
    BoardService bs;
    
    //@Autowired
    //BoardDto dd;
    
    @ApiOperation(value="게시판에 보드를 입력합니다")
    @RequestMapping(value="/restboard", method=RequestMethod.POST)
    public @ResponseBody List<BoardResult> boardInsert(@RequestBody BoardDto b) throws Exception {
        bs.insert(b.getNum(), b.getTitle(), b.getContent());
        
        return bs.selectList();
    }
    
    
    @ApiOperation(value="게시판을 수정합니다")
    @RequestMapping(value="/restboard", method=RequestMethod.PUT)
    public @ResponseBody List<BoardResult> boardUpdate(@RequestBody BoardDto b) throws Exception {
    	bs.update(b.getNum(), b.getTitle(), b.getContent());
        //bs.boardUpdate();
    	
    	return bs.selectList();
    }
    
    // delete 시 uri로 num이 들어오게 한다.
    // @PathVariable ==> path에서 값을 받아온다.
    // 여러개를 받고싶으면 value에 /{변수명} 을 계속 추가 후에, 이와 같은 것으로 @PathVariable로 변수를 받는다.
    // 변수 이름을 따라간다.
    @ApiOperation(value="게시판 삭제")
    @RequestMapping(value="/restboard/{num}", method=RequestMethod.DELETE)
    public void boardDelete(@PathVariable String num) throws Exception {
    	bs.delete(num);
        //bs.boardDelete();
    }
    
    @ApiOperation(value="선택 조회합니다.")
    @RequestMapping(value="/restboard/{num}", method=RequestMethod.GET)
    public @ResponseBody BoardDto boardselectOne(@PathVariable String num) throws Exception {

    	return bs.selectOne(num);
    	    	
    }
    
    @ApiOperation(value="게시판을 조회합니다.", response=List.class)
    @RequestMapping(value="/restboard", method=RequestMethod.GET)
    public @ResponseBody List<BoardResult> boardList() throws Exception{
    	List<BoardResult> selectList = bs.selectList();
    	return selectList;
    }
    
//    @ApiOperation(value="게시판을 삭제합니다")
//    @RequestMapping(value="/restboard/{num}", method=RequestMethod.DELETE)
//    public void boardDelete(@PathVariable String num,
//    						@PathVariable String num4,
//    						@PathVariable String num1) throws Exception {
//        //bs.boardDelete();
//    	
//    	System.out.println("num : " + num);
//    	System.out.println("num : " + num4);
//    	System.out.println("num : " + num1);
//    	
//    	System.out.println(dd.toString());
//    }
}