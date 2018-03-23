package com.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.SysUser;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	SysUser findByUsername(String username);
}
