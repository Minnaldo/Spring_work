package edu.ssafy.food.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import edu.ssafy.food.dto.MemVO;
import edu.ssafy.food.repository.MemRepo;

@Service(value = "MemServiceImpl")
public class MemServiceImpl implements MemService {

	@Autowired
	@Qualifier("MemMybatisRepoImpl")
	private MemRepo repo;

	public MemServiceImpl() {
	}

	@Override
	public void addMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		repo.insert(new MemVO(id, pw, name, addr,email,tel,alinfo));
	}

	@Override
	public void updateMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		repo.update(new MemVO(id, pw, name, addr,email,tel,alinfo));
	}

	@Override
	public void delMem(String id) {
		repo.delete(id);
	}

	@Override
	public MemVO selectOne(String id) {
		return repo.selectOne(id);
	}

	@Override
	public List<MemVO> selectList() {
		return repo.selectList();
	}

//	@Override
//	public boolean isLogin(String id, String pw) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public String searchpw(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchmail(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemVO login(String id, String pw) {
		// TODO Auto-generated method stub
		return repo.login(new MemVO(id, pw, "-1", "-1","-1","-1","-1"));
	}
}
