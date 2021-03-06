package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
