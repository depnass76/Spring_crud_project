package com.redasp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.redasp.pma.entities.Employee;

public interface IEmployeeRepository  extends CrudRepository<Employee,Long> {
	@Override
	public List<Employee> findAll();

}
