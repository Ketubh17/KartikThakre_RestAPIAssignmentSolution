package com.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empmanagement.entity.Roles;



public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
