package com.ssafy.model.repository;

import java.util.List;

import com.ssafy.model.dto.Car;

public interface CarRepository {
	public int insert(Car car);
	public int delete(String num);
	public String selectCode(String vcode);
	public List<Car> selectAll();
	public Car selectOne(String num);
}
