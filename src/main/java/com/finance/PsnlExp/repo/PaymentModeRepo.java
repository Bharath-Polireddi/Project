package com.finance.PsnlExp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance.PsnlExp.entities.PaymentMode;

public interface PaymentModeRepo extends JpaRepository<PaymentMode, String> {

	@Query(value = "select pay_name from Paymentmode WHERE user_name=:username", nativeQuery = true)
	List<String> listPayModesOfUser(@Param("username") String username);
}
