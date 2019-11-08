package edu.ssafy.boot.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.Member;

@Repository(value="MemMybatisRepoImpl")
public class MemMybatisRepoImpl implements MemRepo {
	@Autowired
	private SqlSession ss;

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		ss.insert("sql.member.insertMem", m);
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		ss.update("sql.member.updateMem", m);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		ss.delete("sql.member.deleteMem", id);
	}

	@Override
	public Member selectOne(String id) {
		// TODO Auto-generated method stub
		return ss.selectOne("sql.member.selectMem", id);
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return ss.selectList("sql.member.selectList");
	}

}
