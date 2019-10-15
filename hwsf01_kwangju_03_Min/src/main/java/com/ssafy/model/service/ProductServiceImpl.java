package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;
import com.ssafy.model.repository.ProductRepoImpl;

@Component("service")
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepo repo;
	
	public ProductServiceImpl() {}	
	public ProductServiceImpl(ProductRepo repo) {
		this.repo = repo;
	}

	@Override
	public ProductRepo getRepo() {
		// TODO Auto-generated method stub
		repo = new ProductRepoImpl();
		return repo;
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return repo.selectAll();
	}

	@Override
	public Product select(String id) {
		// TODO Auto-generated method stub
		return repo.select(id);
	}

	@Override
	public int insert(Product product) {
		// TODO Auto-generated method stub
		return repo.insert(product);
	}

	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		return repo.update(product);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return repo.delete(id);
	}

}
