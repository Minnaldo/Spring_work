package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.util.BoardDto;

@Repository("BoardRepositoryImpl")
public class BoardRepositoryImpl implements BoardRepository {
	@Autowired
	SqlSession session;
	
	@Override
	public void insert(BoardDto dto) {
		session.insert("board.insert", dto);
	}

	@Override
	public void update(BoardDto dto) {
		
	}

	@Override
	public void delete(String no) {
		
	}

	@Override
	public BoardDto selectOne(String no) {
		
		return null;
	}

	@Override
	public List<BoardDto> selectlist() {
		List<BoardDto> list = session.selectList("board.selectlist");
		return list;
	}

}
