package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.DepartmentDao;
import com.ems.entities.Department;

@Service //to declare B.L holder spring bean
@Transactional //to manage txs automatically !
public class DepartmentServiceImpl implements DepartmentService {
	//depcy - IoC
	@Autowired //field level D.I
	private DepartmentDao departmentDao;

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentDao.getAllDepartments();
	}

}
