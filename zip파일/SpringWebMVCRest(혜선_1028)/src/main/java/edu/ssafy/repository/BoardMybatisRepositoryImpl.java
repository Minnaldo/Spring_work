package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.BoardDTO;

@Repository("BoardMybatisRepositoryImpl")
public class BoardMybatisRepositoryImpl implements BoardMybatisRepository {
	@Autowired
	private SqlSession session;

	@Override
	public List<BoardDTO> selectAll() {
		return session.selectList("sql.board.selectAll");
	}

	@Override
	public List<BoardDTO> select(BoardDTO b) {
		return session.selectList("sql.board.select", b);
	}

	@Override
	public void insert(BoardDTO b) {
		session.insert("sql.board.insert", b);
	}

	@Override
	public void update(BoardDTO b) throws Exception {
		session.update("sql.board.update", b);
	}

	@Override
	public void delete(BoardDTO b) throws Exception {
		session.update("sql.board.delete", b);
	}
}
