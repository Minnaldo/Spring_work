package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.BoardDTO;

public interface BoardMybatisRepository {
	List<BoardDTO> selectAll() throws Exception;

	List<BoardDTO> select(BoardDTO b) throws Exception;

	void insert(BoardDTO b) throws Exception;

	void update(BoardDTO b) throws Exception;

	void delete(BoardDTO b) throws Exception;
}
