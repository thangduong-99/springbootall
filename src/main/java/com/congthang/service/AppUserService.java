package com.congthang.service;

import com.congthang.entity.AppUser;
import com.congthang.form.AppUserForm;

public interface AppUserService {
	public AppUser createAppUser(AppUserForm form);
	public AppUser checkUserName(String userName);
	public AppUser checkUserEMail(String email);
}
