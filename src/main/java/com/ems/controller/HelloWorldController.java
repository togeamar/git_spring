package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // to declare a spring bean with request handling logic
//singleton & eager - managed by SC
public class HelloWorldController {
	public HelloWorldController() {
		System.out.println("in ctor of " + getClass());
	}
	/*
	 * Add req handling method - to render welcome page
	 * URL - http://host:port/ctx_path/
	 * Method - GET
	 * Ret type - String (LVN - logical view name - forward view name)
	 * Key - /
	 * Value - com.ems.controller.HelloWorldController.renderWelcomePage
	 */
	@RequestMapping("/") // | @GetMapping=@RequestMapping(method=GET)
	public String renderWelcomePage() {
		System.out.println("in render welcome page");
		return "index";
	}
	

}
