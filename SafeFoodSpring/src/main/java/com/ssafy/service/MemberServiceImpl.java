package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.MemRepo;
import com.ssafy.vo.MemVO;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements IMemberService {

	@Autowired
	MemRepo repo;
	
	@Override
	public void insert(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		repo.insert(new MemVO(id, pw, name, addr, email, tel, alinfo));
	}

	@Override
	public void update(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemVO selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemVO> selectList() {
		return repo.selectList();
	}

	@Override
	public MemVO login(MemVO m) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
