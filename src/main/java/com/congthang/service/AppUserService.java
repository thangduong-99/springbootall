package com.congthang.service;

import com.congthang.dto.AppUserDTO;
import com.congthang.entity.AppUser;

public interface AppUserService {
	public AppUser createAppUser(AppUserDTO form);
	public AppUser checkUserName(String userName);
	public AppUser checkUserEMail(String email);
}
