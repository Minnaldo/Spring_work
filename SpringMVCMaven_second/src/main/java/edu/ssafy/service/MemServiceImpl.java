package edu.ssafy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.Member;
import edu.ssafy.repogitory.MemJDBCRepoImpl;
import edu.ssafy.repogitory.MemRepo;

//Service는 MemJDBCRepo 가 필요함.
@Service(value="MemServiceImpl")
public class MemServiceImpl implements MemService {
	@Autowired						//@AutoWired 해주면, 스프링컨테이너가 알아서 잡아서 해준다.
	@Qualifier("MemJDBCRepoImpl")	//Qualifier로 컨테이너에 있는 객체를 가져다 꽂아준다!
	private MemRepo repo;

	public MemServiceImpl() {
				
	}
	
	@Override
	@Transactional
	public void insert(String id, String pw, String name, String email) {
		repo.insert(new Member(id, pw, name, email));
	}

	@Override
	@Transactional
	public void update(String id, String pw, String name, String email) {
		repo.update(new Member(id, pw, name, email));
	}

	@Override
	@Transactional
	public void delete(String id) {
		repo.delete(id);
	}

	@Override
	public Member selectone(String id) {
		return repo.selectone(id);
	}

	@Override
	public List<Member> selectList() {
		return repo.selectList();
	}

}
