package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
