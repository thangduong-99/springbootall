package com.congthang.service;

import com.congthang.entity.AppUser;
import com.congthang.form.AppUserForm;

public interface AppUserService {
	public AppUser createAppUser(AppUserForm form);
}
