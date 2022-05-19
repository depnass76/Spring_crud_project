package com.redasp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.redasp.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project,Long> {
    
	@Override
	public List<Project> findAll();
	
}
