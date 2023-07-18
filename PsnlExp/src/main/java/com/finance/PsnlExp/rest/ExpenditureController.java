package com.finance.PsnlExp.rest;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.PsnlExp.entities.Expenditure;
import com.finance.PsnlExp.repo.ExpenditureRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ExpenditureController {

	@Autowired
	ExpenditureRepo expenditureRepo;

	@GetMapping("list/allExp/byCategory/{categorycode}/{username}")
	@Operation(summary = "List all the expenses of a user by category")
	public List<Expenditure> getAllExpByCat(@PathVariable("categorycode") String categorycode,
			@PathVariable("username") String username) {

		var exp = expenditureRepo.listAllExpByCatAndUsr(username, categorycode,
				PageRequest.of(0, 5, Sort.by("expid").descending()));
		return exp;

	}

	@GetMapping("list/allExp/byPayMode/{payMode}/{username}")
	@Operation(summary = "List all the expenses of a user by PaymentMode")
	public List<Expenditure> getAllExpByPayMode(@PathVariable("payMode") String paymode,
			@PathVariable("username") String username) {

		var exp = expenditureRepo.listAllExpByPayModeAndUsr(username, paymode,
				PageRequest.of(0, 3, Sort.by("expid").descending()));
		return exp;

	}

	@GetMapping("list/allExp/btwDates/{username}/{startDate}/{endDate}")
	@Operation(summary = "List all the expenses of a user between two given dates")
	public List<Expenditure> getAllExpByPayMode(@PathVariable("username") String username,
			@PathVariable("startDate") Date startDate, @Param("endDate") Date endDate) {

		var exp = expenditureRepo.listAllExpBtwDates(username, startDate, endDate,
				PageRequest.of(0, 3, Sort.by("expid").descending()));
		return exp;

	}

	@GetMapping("list/allExp/byTags/{tag}")
	@Operation(summary = "List all the expenses based on the given tags")
	public List<Expenditure> getAllExpByPayMode(@PathVariable("tag") String tag) {

		var exp = expenditureRepo.listAllExpByTags(tag);
		return exp;

	}

	@GetMapping("list/allExp/Cat/Tamount/{month}")
	@Operation(summary = "Total amount for each category in given month")
	public List<String> getAllExpCatAndTamount(@PathVariable("month") int month) {

		var exp = expenditureRepo.listAllExpCatAndTamount(month);
		return exp;

	}

	@GetMapping("/topFiveExp/{username}")
	@Operation(summary = "Top five expenses of a user")
	public List<Expenditure> getTopFive(@PathVariable("username") String username) {
		var exp = expenditureRepo.listTopFiveExp(username, PageRequest.of(0, 5, Sort.by("expid").descending()));
		return exp;
	}

	@DeleteMapping("deleteExpenditure/{id}")
	@Operation(summary = "Delete the expenditure by given id")
	public void delexp(@PathVariable("id") int id) {
		var exp = expenditureRepo.findById(id);
		if (exp != null) {
			expenditureRepo.deleteById(id);
		}
	}

	@PutMapping("updateExp/{amount}/{id}")
	@Operation(summary = "Update the expenditure in table by given amount")
	public void updexp(@PathVariable("amount") double amount, @PathVariable("id") int id) {
		var exp = expenditureRepo.findById(id);
		if (exp.isPresent()) {
			var b = exp.get();
			b.setAmount(amount);
			expenditureRepo.save(b);
		}
	}

	@PostMapping("/addnewexp")
	@Operation(summary = "Add new expenditure")
	public Expenditure addnewexp(@RequestBody Expenditure exp) {
		expenditureRepo.save(exp);

		return exp;
	}

}
