package com.example.OOP.service;

import com.example.OOP.entity.Company;
import com.example.OOP.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyRepository repository;

	public List<Company> getAllCompanies() {
		return repository.findAll();
	}

	public Company getById(int id) {
		return repository.findById(id);
	}

	public List<Company> getByName(String name) {
		return repository.findByName(name);
	}

	public void remove(Company company) {
		repository.delete(company);
	}

	public void add(Company company) {
		repository.save(company);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}
}
