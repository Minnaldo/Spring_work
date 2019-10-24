package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Member;

@Repository("MemMybatisRepoImpl")
public class MemMybatisRepoImpl implements MemRepo {
	@Autowired
	private SqlSession session;	
	
	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		session.insert("member.insertMember", m);
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		session.update("member.updateMember",m);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		session.delete("member.deletMember",id);
	}

	@Override
	public Member selectOne(String id) {
		// TODO Auto-generated method stub
		Member m = session.selectOne("member.selectMember", id);
		return m;
	}

	@Override
	public List<Member> selectList() {
		// TODO Auto-generated method stub
		List<Member> selectList = session.selectList("member.selectMembers");
		return selectList;
	}

}
