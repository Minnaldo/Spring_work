package edu.ssafy.boot.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.Member;

@Repository("MemMybatisRepoImpl")
public class MemMybatisRepoImpl implements MemRepo {

	@Autowired
//	@Qualifier("sqlSession")
	private SqlSession session;
	
	@Override
	public void insert(Member m) {
		session.insert("sql.member.insertMember", m); //member_sql.xml
	}

	@Override
	public void update(Member m) {
		session.update("sql.member.updateMember", m);
	}

	@Override
	public void delete(String id) {
		session.delete("sql.member.deleteMember", id);
	}

	@Override
	public Member selectOne(String id) {
		return session.selectOne("sql.member.selectMember", id);
//		return null;
	}

	@Override
	public List<Member> selectList() {
		return session.selectList("sql.member.selectMembers");
//		return null;
	}


}
