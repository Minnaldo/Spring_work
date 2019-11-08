package com.ssafy.dao;

import java.util.List;

import com.ssafy.vo.MemVO;

public interface MemRepo {
	public void insert(MemVO m);
    public void update(MemVO m);
    public void delete(String id);
    public MemVO selectOne(String id);
    public List<MemVO> selectList();
    public MemVO login(MemVO m);
}
