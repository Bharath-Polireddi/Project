package com.finance.PsnlExp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.PsnlExp.entities.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {

}
