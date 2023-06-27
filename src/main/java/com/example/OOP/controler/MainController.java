package com.example.OOP.controler;

import com.example.OOP.entity.Company;
import com.example.OOP.entity.Employee;
import com.example.OOP.service.CompanyService;
import com.example.OOP.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

	private final CompanyService companyService;
	private final EmployeeService employeeService;

	@GetMapping("/companies")
	public List<Company> showCompaniesList() {
		return companyService.getAllCompanies();
	}

	@PostMapping("/companies/add")
	public Company addCompany(@ModelAttribute(value = "company") Company company) {
		return companyService.add(company);
	}

	@DeleteMapping("/companies/{id}")
	public String deleteCompany(Model model, @PathVariable(value = "id") int id) {
		companyService.delete(id);
		return "Company with ID " + id + " was deleted";
	}

	@PostMapping("/companies/{company_id}/add")
	public Employee hireEmployee(@ModelAttribute(value = "employee") Employee employee,
								 @PathVariable(value = "company_id") int id) {
		return employeeService.hire(employee, id);
	}

	@GetMapping("/companies/show/{id}")
	public Company showOneCompany(Model model, @PathVariable(value = "id") int id) {
		return companyService.getById(id);
	}

	@GetMapping("/employees")
	public List<Employee> showEmployeesList() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/show/{id}")
	public Employee showOneEmployee(Model model, @PathVariable(value = "id") int id) {
		return employeeService.getById(id);
	}

	@PostMapping("/employees/add")
	public Employee addEmployee(@ModelAttribute(value = "employee") Employee employee) {
		return employeeService.add(employee);
	}

	@DeleteMapping ("/employees/{id}")
	public String deleteEmployee(Model model, @PathVariable(value = "id") int id) {
		employeeService.delete(id);
		return "Employee with ID " + id + " was deleted";
	}
}
