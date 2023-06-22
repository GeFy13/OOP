package com.example.OOP.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "salary")
	private int salary;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	public Type type;

	public Employee() {

	}

	public enum Type {
		MANAGER, TOPMANAGER, OPERATOR
	}

	public Employee(Type type) {
		this.type = type;
		salary = (int)(Math.random()*(80000-60000) + 60000);
	}
}
