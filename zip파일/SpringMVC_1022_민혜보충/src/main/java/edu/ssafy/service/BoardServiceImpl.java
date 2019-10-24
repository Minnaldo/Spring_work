package edu.ssafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.repository.BoardRepository;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository rep;
	
}
