package com.finance.PsnlExp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.PsnlExp.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, String>{
             
}
