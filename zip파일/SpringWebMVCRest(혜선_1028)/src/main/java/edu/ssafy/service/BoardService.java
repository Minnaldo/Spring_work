package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.BoardDTO;

public interface BoardService {
	List<BoardDTO> selectAll() throws Exception;

	List<BoardDTO> select(BoardDTO b) throws Exception;

	void insert(BoardDTO b) throws Exception;

	void update(BoardDTO b) throws Exception;

	void delete(BoardDTO b) throws Exception;
}
