package com.congthang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.congthang.entity.AppUser;
import com.congthang.form.AppUserForm;
import com.congthang.repository.AppUserRepository;
import com.congthang.service.AppUserService;
@Service
public class AppUserServiceImpl implements AppUserService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AppUserRepository appUserRepository;
	@Override
	public AppUser createAppUser(AppUserForm form) {
		String encrytedPassword = this.passwordEncoder.encode(form.getPassword());
		AppUser user = new AppUser(form.getUserName(), //
				encrytedPassword, true, form.getFirstName(), form.getLastName(),
				form.getEmail());
		appUserRepository.save(user);
		return user;
	}

}
