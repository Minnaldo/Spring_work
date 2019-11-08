package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;

@Repository
public class BoardMybatisRepositoryImpl implements BoardRepository {

	@Autowired
	SqlSession session;

	@Override
	public void insert(BoardDto dto) throws Exception {
		session.insert("board.insert", dto);		
	}


	@Override
	public void update(BoardDto dto) throws Exception {
		session.update("board.update", dto);
		
	}

	@Override
	public void delete(String num) throws Exception {
		session.delete("board.delete", num);
		
	}
	
	@Override
	public BoardDto selectOne(String num) throws Exception {
		
		return session.selectOne("board.selectOne", num);
	}
	
	@Override
	public List<BoardResult> selectList() throws Exception {
		return session.selectList("board.selectList");
	}


	
	
}
