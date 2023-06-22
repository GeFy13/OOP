package com.example.OOP.controler;

import com.example.OOP.entity.Company;
import com.example.OOP.entity.Employee;
import com.example.OOP.service.CompanyService;
import com.example.OOP.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class MainController {

	private final CompanyService companyService;
	private final EmployeeService employeeService;

	@GetMapping
	public List<Company> showCompaniesList() {
		return companyService.getAllCompanies();
	}

	@PostMapping("/add")
	public Company addCompany(@ModelAttribute(value = "company") Company company) {
		companyService.add(company);
		return company;
	}

	@DeleteMapping("/{id}")
	public String deleteCompany(Model model, @PathVariable(value = "id") int id) {
		companyService.delete(id);
		return "Company with ID " + id + " was deleted";
	}

	@GetMapping("/show/{id}")
	public Company showOneCompany(Model model, @PathVariable(value = "id") int id) {
		Company company = companyService.getById(id);
		return company;
	}

	@GetMapping("/show/{id_company}/show/{id_employee}")
	public Employee showOneEmployee(Model model,
								  @PathVariable(value = "id_company") int id_company,
								  @PathVariable(value = "id_employee") int id_employee) {
		Employee employee = employeeService.getById(id_employee);
		return employee;
	}

	@PostMapping("/{id_company}/add")
	public Employee addEmployee(@ModelAttribute(value = "employee") Employee employee,
							  @PathVariable(value = "id_company") int id_company) {
		Company company = companyService.getById(id_company);
		employeeService.add(employee, company);
		return employee;
	}

	@DeleteMapping ("/{id_company}/{id_employee}")
	public String deleteEmployee(Model model,
								  @PathVariable(value = "id_company") int id_company,
								  @PathVariable(value = "id_employee") int id_employee) {
		employeeService.delete(id_employee);
		return "Employee with ID " + id_employee + " was deleted";
	}
}
