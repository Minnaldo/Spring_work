package edu.ssafy.food.repository;

import java.util.List;

import edu.ssafy.food.dto.MemVO;

public interface MemRepo {
	public void insert(MemVO m);
	public void update(MemVO m);
	public void delete(String id);
	public MemVO selectOne(String id);
	public List<MemVO> selectList();
	public MemVO login(MemVO m);
}
