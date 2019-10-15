package com.ssafy.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.DAO.ProductConfig;
import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

public class BeanTest {
	public static void main(String[] args) {
		BeanFactory fac = new AnnotationConfigApplicationContext(ProductConfig.class);
		ProductService ps = (ProductService) fac.getBean("service");
		//입력
		if(ps.insert(new Product("Q950R","QLED_TV","SAMSUNG", 16400000,"QLED_TV")) > 0) {
			System.out.println(ps.select("Q950R").toString());//정보 하나 출력
			System.out.println("-----------------------------------------------------------------------");
		}
		//입력
		if(ps.insert(new Product("RQ48R942132","냉장고","삼성",3930000,"BESPOKE_냉장고")) > 0) {
			System.out.println(ps.select("RQ48R942132").toString());//정보 하나 출력
			System.out.println("-----------------------------------------------------------------------");
		}
		//전체 출력
		if(ps.selectAll() != null) {//출력
			for (Product p : ps.selectAll()) {
				System.out.println(p.toString());
			}
		}
		System.out.println("-----------------------------------------------------------------------");
		//업데이트
		if(ps.update(new Product("RF61R91C3AP", "냉장고", "삼성전자", 3100000, "BESPOKE_4도어")) > 0) {
			System.out.println(ps.select("RF61R91C3AP").toString());//정보 하나 출력
			System.out.println("-----------------------------------------------------------------------");
		}
		//삭제
		ps.delete("RF61R91C3AP");
		if(ps.selectAll() != null) {//출력
			for (Product p : ps.selectAll()) {
				System.out.println(p.toString());
			}
		}
//		System.out.println("-----------------------------------------------------------------------");
	}
}