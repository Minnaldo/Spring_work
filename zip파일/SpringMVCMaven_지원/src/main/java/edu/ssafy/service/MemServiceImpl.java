package edu.ssafy.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.Member;
import edu.ssafy.repository.MemRepo;
@Service(value="MemServiceImpl")
public class MemServiceImpl implements MemService {
    @Autowired
    @Qualifier("MemMybatisRepoImpl")
    private MemRepo repo;
    
    public MemServiceImpl() {
        
    }
    @Override
    @Transactional
    public void insert(String id, String pw, String name, String email) {
        repo.insert(new Member(id,pw,name,email));
    }
    @Override
    @Transactional
    public void update(String id, String pw, String name, String email) {
        repo.update(new Member(id,pw,name,email));
    }
    @Override
    @Transactional
    public void delete(String id) {
        repo.delete(id);
    }
    @Override
    public Member selectOne(String id) {
        
        return repo.selectOne(id);
    }
    @Override
    public List<Member> selectList() {
        return repo.selectList();
    }
}
