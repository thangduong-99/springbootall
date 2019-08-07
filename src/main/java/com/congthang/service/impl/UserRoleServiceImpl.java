package com.congthang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congthang.entity.UserRole;
import com.congthang.repository.UserRoleRepository;
import com.congthang.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	UserRoleRepository userRoleRepository;
	@Override
	public UserRole creatUserRole(Long a, Long b) {
		UserRole userRole = new UserRole();
		userRole.setRoleId(a);
		userRole.setUserId(b);
		userRoleRepository.save(userRole);
		return userRole;
	}
	
}
