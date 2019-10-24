package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Product;

@Repository(value="ProductMybatisRepoImpl")
public class ProductMybatisRepoImpl implements ProductRepo {
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession ss;

	@Override
	public void insert(Product p) {
		// TODO Auto-generated method stub
		ss.insert("product.insertProduct", p);
	}

	@Override
	public void update(Product p) {
		// TODO Auto-generated method stub
		ss.update("product.updateProduct", p);
	}

	@Override
	public void delete(String num) {
		// TODO Auto-generated method stub
		ss.delete("product.deleteProduct", num);
	}

	@Override
	public Product selectOne(String num) {
		// TODO Auto-generated method stub
		return ss.selectOne("product.selectProduct", num);
	}

	@Override
	public List<Product> selectList() {
		// TODO Auto-generated method stub
		return ss.selectList("product.selectList");
	}
	
}