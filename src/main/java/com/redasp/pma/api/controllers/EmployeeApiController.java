package com.redasp.pma.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redasp.pma.dao.IEmployeeRepository;
import com.redasp.pma.entities.Employee;

@RestController
@RequestMapping("/app.api/employees")
public class EmployeeApiController {

	@Autowired
	IEmployeeRepository empRepo;

	@GetMapping
	public Iterable<Employee> getEmployee() {
		return empRepo.findAll();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return empRepo.findById(id).get();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@RequestBody @Validated Employee employee) {
		return empRepo.save(employee);
	}

	@PutMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee update(@RequestBody @Validated Employee employee) {
		return empRepo.save(employee);
	}

	@PatchMapping(path = "/{id}", consumes = "application/json")
	public Employee partialUpdate(@PathVariable("id") long id, @RequestBody @Validated Employee patchEmployee) {
		
		Employee emp = empRepo.findById(id).get();

		if (patchEmployee.getEmail() != null) {
			emp.setEmail(patchEmployee.getEmail());
		}
		if (patchEmployee.getFirstName() != null) {
			emp.setFirstName(patchEmployee.getFirstName());
		}
		if (patchEmployee.getLastName() != null) {
			emp.setLastName(patchEmployee.getLastName());
		}

		return empRepo.save(emp);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") long id) {
		try {
			empRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

		}
	}

	@GetMapping(params = { "page", "size" })
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> findPignationEmployees(@RequestParam("page") int page, @RequestParam("size") int size) {
		Pageable pageAndSize = PageRequest.of(page, size);

		return empRepo.findAll(pageAndSize );

	}
	
	@GetMapping(params = { "sort", "size" })
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> findSortingEmployees(@RequestParam("sort") int sort, @RequestParam("size") int size) {
		Pageable sortAndSize = PageRequest.of(sort, size);

		return empRepo.findAll(sortAndSize );

	}

}
