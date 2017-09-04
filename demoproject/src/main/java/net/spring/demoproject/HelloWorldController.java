package net.spring.demoproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld(){
		System.out.println("hello");
		String message="hello World";
		return new ModelAndView("hellopage","message", message);
	}
	
}
