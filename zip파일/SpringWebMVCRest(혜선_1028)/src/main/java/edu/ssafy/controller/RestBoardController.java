package edu.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.dto.BoardDTO;
import edu.ssafy.service.BoardService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class RestBoardController {

	@Autowired
	private BoardService ser;

	// @RequestBody --> 클라이언트에서 json으로 보내면 BoardDTO로 매핑해준다
	@ApiOperation(value = "게시판에 글을 등록합니다")
	@RequestMapping(value = "/restboard", method = RequestMethod.POST)
	public @ResponseBody List<BoardDTO> boardinsert(@RequestBody BoardDTO b) throws Exception {
		ser.insert(b);
		return ser.selectAll();
	}

	// value에는 이 메소드의 기능을 적는다, response=리턴타입을 지정
	@ApiOperation(value = "게시판 리스트를 가져옵니다", response = List.class)
	// @ResponseBody --> 결과물을 json으로 바꾸어 전송해준다
	@RequestMapping(value = "/restboard", method = RequestMethod.GET)
	public @ResponseBody List<BoardDTO> boardlist() throws Exception {
		return ser.selectAll();
	}

	@ApiOperation(value = "선택된 요소의 상세정보를 가져옵니다", response = BoardDTO.class)
	@RequestMapping(value = "/restboard/{num}", method = RequestMethod.GET)
	public @ResponseBody List<BoardDTO> select(@PathVariable String num) throws Exception {
		return ser.select(new BoardDTO(num, "", "", ""));
	}

	@ApiOperation(value = "게시판의 내용을 수정합니다")
	@RequestMapping(value = "/restboard", method = RequestMethod.PUT)
	public @ResponseBody List<BoardDTO> update(@RequestBody BoardDTO b) throws Exception {
		ser.update(b);
		return ser.selectAll();
	}

	// delete시 uri로 num이 들어오게 한다
	// @PathVariable ==> path에서 값을 받아온다
	// 여러개를 받고싶으면 value에 /{변수명} 을 계속 추가 후에, 이와 같은 것으로 @PathVariable로 변수를 받는다
	// 변수 이름을 따라간다
	@ApiOperation(value = "게시판 내용을 삭제합니다")
	@RequestMapping(value = "/restboard/{num}", method = RequestMethod.DELETE)
	public @ResponseBody List<BoardDTO> delete(@PathVariable String num) throws Exception {
		ser.delete(new BoardDTO(num, "", "", ""));
		return ser.selectAll();
	}
}
