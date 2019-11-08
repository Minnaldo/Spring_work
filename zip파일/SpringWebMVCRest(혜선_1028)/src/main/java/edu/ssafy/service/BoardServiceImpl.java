package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.ssafy.dto.BoardDTO;
import edu.ssafy.exception.boardException;
import edu.ssafy.repository.BoardMybatisRepository;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMybatisRepository rep;

	@Override
	@Transactional
	public List<BoardDTO> selectAll() throws Exception {
		return rep.selectAll();
	}

	@Override
	@Transactional
	public List<BoardDTO> select(BoardDTO b) throws Exception {
		return rep.select(b);
	}

	@Override
	@Transactional
	public void insert(BoardDTO b) throws Exception {
		rep.insert(b);
	}

	@Override
	@Transactional
	public void update(BoardDTO b) throws Exception {
		rep.update(b);
	}

	@Override
	@Transactional
	public void delete(BoardDTO b) throws Exception {
		rep.delete(b);
	}

}
