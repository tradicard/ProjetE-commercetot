package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.Entity.Role;



public interface IRoleDao extends JpaRepository<Role, Integer> {

}
