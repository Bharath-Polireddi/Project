package com.finance.PsnlExp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.finance.PsnlExp.repo.UsersRepo;

@RestController
public class UserController {

	@Autowired
	UsersRepo usersRepo;

}
