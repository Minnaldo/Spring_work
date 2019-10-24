package edu.ssafy.repository;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.Member;

@Repository("MemMybatisRepoImpl")
public class MemMybatisRepoImpl implements MemRepo{
	
	@Autowired
	private SqlSession session;
	@Override
	public void insert(Member m) {
		session.insert("member.insertMember", m);
	}

	@Override
	public void update(Member m) {
		session.update("member.updateMember", m);
	}

	@Override
	public void delete(String id) {
		session.delete("member.deleteMember", id);
	}

	@Override
	@Transactional
	public Member selectOne(String id) {
		Member m = session.selectOne("member.selectMember", id);
		return m;
	}

	@Override
	public List<Member> selectList() {
		List<Member> list = session.selectList("member.selectMembers");
		return list;
	}

}
