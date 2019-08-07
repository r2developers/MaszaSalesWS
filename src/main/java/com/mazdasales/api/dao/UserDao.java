package com.mazdasales.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazdasales.api.model.User;

public interface UserDao extends JpaRepository<User, Long> {

}
