package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.MemVO;

public interface IMemberService {
	public void insert(String id, String pw, String name, String addr, String email, String tel, String alinfo);
    public void update(String id, String pw, String name, String addr, String email, String tel, String alinfo);
    public void delete(String id);
    public MemVO selectOne(String id);
    public List<MemVO> selectList();
    public MemVO login(MemVO m);
}
