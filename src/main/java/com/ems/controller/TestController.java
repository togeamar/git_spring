package com.ems.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // request handling controller(Handler) - spring bean - singleton & eager
@RequestMapping("/test") //optional annotation to declare base URL pattern
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}
	/*
	 * Add req handling method , to render dynamic resp - server side Timestamp)
	 * URL - http://host:port/ctx/test/test1, method - GET
	 * Resp - dyn resp 
	 * In HandlerMapping
	 * Key - /test/test1 + method=GET
	 * Value - com.ems.controller.TestController.testModelAndView
	 */
	@GetMapping("/test1")  // doGet
	public ModelAndView testModelAndView()
	{
		System.out.println("in test model & view");
		//create ModelAndView object to return - model(data) + view name
		return new ModelAndView("test/display", "server_ts", LocalDateTime.now());//AVN - /WEB-INF/views/test/display.jsp
	}
	/*
	 * Add req handling method , to render dynamic resp - server side Timestamp , List of numbers)
	 * URL - http://host:port/ctx/test/test2, method - GET
	 * Resp - dyn resp 
	 * In HandlerMapping
	 * Key - /test/test2 + method=GET
	 * Value - com.ems.controller.TestController.testModelMap
	 */
	@GetMapping("/test2")
	public String testModelMap(Model modelAttrMap) {
		System.out.println("in test model map - "+modelAttrMap);// empty map  - {}
		//add model attribute/s 
		modelAttrMap
		.addAttribute("server_time", LocalTime.now())
		.addAttribute("number_list", List.of(10, 20, 30));		
		System.out.println("in test model map - "+modelAttrMap);//populated map
		return "test/display2"; 
	}
	/*
	 *  Handler rets explicitly LVN -> D.S
	 *  SC adds implicitly model map -> D.S
	 *  D.S -> LVN -> V.R -> AVN -> D.S
	 * D.S -> results from model map -> adds them request scope -> 
	 * -> forwards the request -> JSP (${....}
	 *  AVN - /WEB-INF/views/test/display2.jsp
	*/
	
	
}
