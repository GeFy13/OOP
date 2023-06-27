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

	private final CompanyService companyService;

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

	public Employee add(Employee employee) {
		employee.setSalary((int) (Math.random() * (100000 - 60000) + 60000));
		switch (employee.getType()) {
				case OPERATOR -> {
				}
				case MANAGER -> {
					int income = (int) (Math.random() * (140000 - 115000) + 115000);
					employee.setSalary(employee.getSalary() + (int) (income * 0.1));
				}
				case TOPMANAGER -> {
					int company_income = employee.getCompany().getIncome();
					if (company_income > 1000000)
						employee.setSalary(employee.getSalary() + (int) (company_income * 0.01));
				}
			}
		return repository.save(employee);
	}

	public Employee hire(Employee employee, int id_company) {
		employee.setCompany(companyService.getById(id_company));
		return add(employee);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public List<Employee> getAllEmployeesInCompany(Company company) {
		return repository.findByCompany(company);
	}
}
