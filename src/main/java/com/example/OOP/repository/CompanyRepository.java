package com.example.OOP.repository;

import com.example.OOP.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	Company findById(int id);
	List<Company> findByName(String name);
	void deleteById(int id);
}
