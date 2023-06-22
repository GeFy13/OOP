package com.example.OOP.repository;

import com.example.OOP.entity.Company;
import com.example.OOP.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findById(int id);
	List<Employee> findByCompany(Company company);
	List<Employee> findByType(Employee.Type type);
	void deleteById(int id);
}
