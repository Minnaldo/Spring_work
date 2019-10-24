package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ssafy.dto.Product;
import edu.ssafy.repository.ProductRepo;

@Service(value="ProductServiceImpl")
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Qualifier("ProductMybatisRepoImpl")
	private ProductRepo prepo;
	
	public ProductServiceImpl() {}

	@Override
	public void insert(String num, String name, String price, String quantity) {
		// TODO Auto-generated method stub
		prepo.insert(new Product(num, name, price, quantity));
	}

	@Override
	public void update(String num, String name, String price, String quantity) {
		// TODO Auto-generated method stub
		prepo.update(new Product(num, name, price, quantity));
	}

	@Override
	public void delete(String num) {
		// TODO Auto-generated method stub
		prepo.delete(num);
	}

	@Override
	public Product selectOne(String num) {
		// TODO Auto-generated method stub
		return prepo.selectOne(num);
	}

	@Override
	public List<Product> selectList() {
		// TODO Auto-generated method stub
		return prepo.selectList();
	}

}
