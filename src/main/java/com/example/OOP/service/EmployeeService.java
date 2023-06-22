package com.example.OOP.service;

import com.example.OOP.entity.Company;
import com.example.OOP.entity.Employee;
import com.example.OOP.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	public List<Employee> getAllCompanies() {
		return repository.findAll();
	}

	public Employee getById(int id) {
		return repository.findById(id);
	}

	public List<Employee> getByType(Employee.Type type) {
		return repository.findByType(type);
	}

	public void remove(Employee employee) {
		repository.delete(employee);
	}

	public void add(Employee employee, Company company) {
		company.hire(employee);
		repository.save(employee);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public List<Employee> getAllEmployeesInCompany(Company company) {
		return repository.findByCompany(company);
	}
}
