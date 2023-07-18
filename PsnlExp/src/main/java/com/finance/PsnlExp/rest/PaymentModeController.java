package com.finance.PsnlExp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.PsnlExp.entities.PaymentMode;
import com.finance.PsnlExp.repo.PaymentModeRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class PaymentModeController {
	@Autowired
	PaymentModeRepo paymentModeRepo;

	@PostMapping("/add/new/paymentMode")
	@Operation(summary = "Add new paymentmode for a user with required details")
	public PaymentMode addNewPaymentMode(@RequestBody PaymentMode pm) {
		paymentModeRepo.save(pm);
		return pm;
	}

	@GetMapping("/list/paymentModes/{username}")
	@Operation(summary = "List payment modes of given user")
	public List<String> getlistpay(@PathVariable("username") String username) {
		return paymentModeRepo.listPayModesOfUser(username);
	}

	@DeleteMapping("/delete/paymentMode/{code}")
	@Operation(summary = "Delete Payment mode of given user")
	public void delpay(@PathVariable("code") String code) {
		var a = paymentModeRepo.findById(code);
		if (a != null) {

			paymentModeRepo.deleteById(code);

		}
	}

	@PutMapping("/updpaymentmode/{code}/{username}/{name}")
	@Operation(summary = "Update payment mode of given user")
	public void updpay(@PathVariable("code") String code, @PathVariable("username") String username,
			@PathVariable("name") String name)

	{
		var a = paymentModeRepo.findById(code);
		if (a.isPresent()) {
			var b = a.get();
			if (b.getPaymentuser().getUser_name().equals(username)) {
				b.setPaymentType(name);
				paymentModeRepo.save(b);
			}
		}

	}

}
