package com.congthang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congthang.entity.AppRole;
import com.congthang.repository.AppRoleRepository;
import com.congthang.service.AppRoleService;
@Service
public class AppRoleServiceImpl implements AppRoleService{
	@Autowired
	AppRoleRepository appRoleRepository;
	@Override
	public AppRole creatAppRole() {
		AppRole appRole = new AppRole();
		appRole.setRoleName("ROLE_USER");
		appRoleRepository.save(appRole);
		return appRole;
	}

}
