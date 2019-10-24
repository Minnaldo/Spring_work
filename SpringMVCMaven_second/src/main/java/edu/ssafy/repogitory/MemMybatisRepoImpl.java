package edu.ssafy.repogitory;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Member;

@Repository(value="MemMybatisRepoImpl")
public class MemMybatisRepoImpl implements MemRepo {

//	@Qualifier("sqlSession")
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(Member m) {
		session.insert("sql.member.insertMember", m);
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
	public Member selectone(String id) {
		
		Member m = session.selectOne("sql.member.selectMember", id);
		
		return m;
	}

	@Override
	public List<Member> selectList() {
		List<Member> selectList = session.selectList("sql.member.selectMembers");
		for (int i = 0; i < selectList.size(); i++) {
			System.out.println(selectList.get(i).toString());
		}
		return selectList;
	}

}
