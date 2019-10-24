package com.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.dto.Car;
import com.ssafy.model.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService service;
	
	@RequestMapping("index.do")
	public void index() {
		
	}
	
	@RequestMapping("list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.selectAll());
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping("addForm.do")
	public void addForm() {}
	
	@RequestMapping("addCar.do")
	public String addCar(Car car) {
		
		boolean result = service.addCar(car);
		
		if(result) {
			return "redirect: list.do";
		}
		return "redirect: addForm.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(String num) {
		service.delete(num);
		
		return "redirect: list.do";
	}
	
	@RequestMapping("view.do")
	public Car view(String num) {
		System.out.println(num);
		Car c = service.selectOne(num);
		
		return c;
	}
}
