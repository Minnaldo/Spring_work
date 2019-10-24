package edu.ssafy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.service.BoardService;

@Repository("BoardRepositoryImpl")
public class BoardRepositoryImpl implements BoardRepository {
	
	@Autowired
	private BoardService ser;
}
