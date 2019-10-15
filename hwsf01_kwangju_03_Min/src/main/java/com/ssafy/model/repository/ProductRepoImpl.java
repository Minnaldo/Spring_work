package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.DAO.ConnectionProxy;
import com.ssafy.model.dto.Product;

@Component("repo")
public class ProductRepoImpl implements ProductRepo {
	private List<Product> list;

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public ProductRepoImpl() {}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		String query = "select * from products";

		try {
			conn = ConnectionProxy.getConnection();
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();

			list = new LinkedList<Product>();

			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));
				p.setCompany(rs.getString("company"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("description"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public Product select(String id) {
		// TODO Auto-generated method stub
		String query = "select * from products where id = ?";
		Product p = null;
		try {
			conn = ConnectionProxy.getConnection();
			pst = conn.prepareStatement(query);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				p = new Product();
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));
				p.setCompany(rs.getString("company"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return p;
	}

	@Override
	public int insert(Product product) {
		// TODO Auto-generated method stub
		String query = "insert into products (id, name, company, price, description) values(?, ?, ?, ?, ?)";
		int res = 0;
		
		try {
			conn = ConnectionProxy.getConnection();
			pst = conn.prepareStatement(query);
			
			pst.setString(1, product.getId());
			pst.setString(2, product.getName());
			pst.setString(3, product.getCompany());
			pst.setInt(4, product.getPrice());
			pst.setString(5, product.getDescription());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		String query = "update products set name = ?, company = ?, price = ?, description = ? where id = ?";
		int res = 0;
		
		try {
			conn = ConnectionProxy.getConnection();
			pst = conn.prepareStatement(query);
			
			pst.setString(1, product.getName());
			pst.setString(2, product.getCompany());
			pst.setInt(3, product.getPrice());
			pst.setString(4, product.getDescription());
			pst.setString(5, product.getId());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		String query = "delete from products where id = ?";
		int res = 0;
		try {
			conn = ConnectionProxy.getConnection();
			pst = conn.prepareStatement(query);
			pst.setString(1, id);
//			rs = pst.executeQuery();
			
			res = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pst != null) pst.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
