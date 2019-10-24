package edu.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.ssafy.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService ser;
}
