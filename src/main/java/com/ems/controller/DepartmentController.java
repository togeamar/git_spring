package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ems.service.DepartmentService;

@Controller // handler - spring bean
@RequestMapping("/departments")
public class DepartmentController {
	// depcy - service layer i/f
	@Autowired // by type - field level D.I
	private DepartmentService departmentService;

	public DepartmentController() {
		System.out.println("in ctor of " + getClass());
	}

	/*
	 * Add request handling method - to render list of all depts fetched from DB URL
	 * - http://host:port/ctx/departments/list , method - GET resp - LVN + Model map
	 */
	@GetMapping("/list")
	public String listAllDepartments(Model map) {
		System.out.println("in list all depts " + map);// {}
		// invoke service layer method -> result (List) -> store in under Model attr map
		map.addAttribute("department_list", departmentService.getAllDepartments());
		//return LVN
		return "departments/list";
		/*
		 * AVN - /WEB-INF/views/departments/list.jsp
		 */

	}

}
