package edu.ssafy.food.repository;

import java.sql.SQLException;
import java.util.List;

import org.w3c.dom.Element;

import edu.ssafy.food.dto.FoodVO;

public class FoodMybatisRepoImpl implements FoodRepo{

	@Override
	public List<FoodVO> getFoodList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodVO getFood(int code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodVO getFoodname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodVO> getFoodnamelist(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadData(String url, String url2) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FoodVO> productparsing1(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodVO> productparsing2(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTagValue(String tag, Element eElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodVO> getFoodmaker(String maker) {
		// TODO Auto-generated method stub
		return null;
	}

}
