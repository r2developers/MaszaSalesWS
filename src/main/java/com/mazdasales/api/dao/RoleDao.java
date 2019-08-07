package com.mazdasales.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazdasales.api.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
