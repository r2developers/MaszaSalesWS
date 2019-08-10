package com.mazdasales.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazdasales.api.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
