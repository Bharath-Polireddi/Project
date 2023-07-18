package com.finance.PsnlExp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.PsnlExp.entities.Category;
import com.finance.PsnlExp.repo.CategoryRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepo categoryRepo;

	@GetMapping("list/categories")
	@Operation(summary = "List all the available Categories")
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

}
