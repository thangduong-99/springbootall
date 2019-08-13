package com.congthang.service;

import java.util.List;
import java.util.Optional;

import com.congthang.dto.AppUserDTO;
import com.congthang.entity.AppUser;

public interface AppUserService {
	public AppUser createAppUser(AppUserDTO form);
	public AppUser checkUserName(String userName);
	public AppUser checkUserEMail(String email);
	public List<AppUser> getAllUser();
	public Optional<AppUser> getUserById(long id);
	public void updateUser(AppUser appUser);
	public List<AppUser> managementUser();
    public void deleteUserById(int id);
//    public void deleteManageUser(Long id);
//    public void deleteManageUserRole(Long id);
}
