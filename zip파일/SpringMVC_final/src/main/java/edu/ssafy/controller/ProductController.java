package edu.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Product;
import edu.ssafy.exception.MyException;
import edu.ssafy.service.ProductService;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	private List<Product> list = null;
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService ps;
	
	@ExceptionHandler(MyException.class)
	public String myExceptionMethod(MyException e){
		e.trace();
		return "myerror";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionMethod(Exception e, Model m){
		e.printStackTrace();
		m.addAttribute("exception", e);
		return "myerror";
	}
	
	@RequestMapping("/productregpage")
	public ModelAndView regPage(ModelAndView mv) {
		mv.setViewName("product/productreg");
		return mv;
	}
	
	@RequestMapping("/productinsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		
		String num = req.getParameter("num");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String quantity = req.getParameter("quantity");
		
		ps.insert(num, name, price, quantity);
		list = ps.selectList();
		
		mv.addObject("list", list);
		mv.setViewName("/product/productlist");
		
		return mv;
	}
	
	@RequestMapping("/productupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {

		String num = req.getParameter("num");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String quantity = req.getParameter("quantity");
		
		ps.update(num, name, price, quantity);
		list = ps.selectList();
		
		mv.addObject("list", list);
		mv.setViewName("/product/productlist");
		return mv;
	}
	
	@RequestMapping("/productdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {

		String num = req.getParameter("num");
		
		ps.delete(num);
		list = ps.selectList();
		
		mv.addObject("list", list);
		mv.setViewName("/product/productlist");
		return mv;
	}
	
	@RequestMapping("/productselectone")
	public ModelAndView selectone(HttpServletRequest req, ModelAndView mv) {
		String num = req.getParameter("num");
		Product p = ps.selectOne(num);
		
		mv.addObject("product", p);
		mv.setViewName("/product/productview");
		return mv;
	}
	
	@RequestMapping("/productselectlist")
	public ModelAndView selectlist(HttpServletRequest req, ModelAndView mv) {
		list = ps.selectList();
		
		mv.addObject("list", list);
		mv.setViewName("/product/productlist");
		return mv;
	}
}