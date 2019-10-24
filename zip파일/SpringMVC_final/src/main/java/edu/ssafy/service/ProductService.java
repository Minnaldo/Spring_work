package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.Product;

public interface ProductService {
	public void insert(String num, String name, String price, String quantity);
	public void update(String num, String name, String price, String quantity);
	public void delete(String num);
	public Product selectOne(String num);
	public List<Product> selectList();
}