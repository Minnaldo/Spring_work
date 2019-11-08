package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.MemVO;

@Repository("MemMybatisRepository")
public class MemMybatisRepository implements MemRepo {

	@Autowired
	SqlSession session;
	
	@Override
	public void insert(MemVO m) {
		session.insert("sql.member.insertMember", m);	//member_sql.xml
	}

	@Override
	public void update(MemVO m) {
		// TODO Auto-generated method stub
		
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
		return session.selectList("sql.member.selectMembers");
	}

	@Override
	public MemVO login(MemVO m) {
		// TODO Auto-generated method stub
		return null;
	}

}
