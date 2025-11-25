package com.ems.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entities.Department;

@Repository //to declare a spring bean containing data access logic 
//singleton & eager
public class DepartmentDaoImpl implements DepartmentDao {
	//depcy
	@Autowired //matched by type
	private SessionFactory factory;

	@Override
	public List<Department> getAllDepartments() {
		String jpql="select d from Department d";
		return factory.getCurrentSession() //Session
				.createQuery(jpql, Department.class)
				.getResultList();
	}

}
