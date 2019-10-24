package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Car;
import com.ssafy.model.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepo;

	public boolean addCar(Car car) {
		try {
			String endor = carRepo.selectCode(car.getVcode());
			if (endor != null) {
				car.setVendor(endor);
				int result = carRepo.insert(car);

				if (result > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public int delete(String num) {
		return carRepo.delete(num);

	}

	public Car selectOne(String num) {
		return carRepo.selectOne(num);
	}
	
	public List<Car> selectAll() {
		return carRepo.selectAll();
	}
}
