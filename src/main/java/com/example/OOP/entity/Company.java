package com.example.OOP.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "company")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Employee> employeeList;

	@Column(name = "income")
	private int income;

	public Company() {
		this.income = 0;
		employeeList = new ArrayList<>();
	}

	public void hire(Employee employee) {
		employee.setCompany(this);
		typeEmployeeSwitch(employee);
		employeeList.add(employee);
	}

	public void hireAll(List<Employee> list) {
		for (Employee e : list) hire(e);
	}

	public void typeEmployeeSwitch(Employee employee) {
		employee.setSalary((int)(Math.random()*(80000-60000) + 60000));
		switch (employee.type) {
			case OPERATOR -> {
				break;
			}
			case MANAGER -> {
				int income = (int) (Math.random() * (140000 - 115000) + 115000);
				this.income += income;
				employee.setSalary(employee.getSalary() + (int) (income * 0.10));
			}
			case TOPMANAGER -> {
				if (this.income >= 1_500_000) employee.setSalary(employee.getSalary() + (int) (this.income * 0.10));
				;
			}
		}
	}
}