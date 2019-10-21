package edu.ssafy.controller;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public String home(HttpServletRequest req, HttpServletResponse res, Model m) {
		
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, );
		String format = df.format(date);
		System.out.println(format);
				
		return "";
	}
}
