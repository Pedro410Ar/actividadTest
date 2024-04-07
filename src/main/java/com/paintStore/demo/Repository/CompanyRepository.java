package com.paintStore.demo.Repository;

import com.paintStore.demo.Model.Company;
import com.paintStore.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
