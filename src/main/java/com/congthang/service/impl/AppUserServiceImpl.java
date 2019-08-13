package com.congthang.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.congthang.dto.AppUserDTO;
import com.congthang.entity.AppUser;
import com.congthang.repository.AppUserRepository;
import com.congthang.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public AppUser createAppUser(AppUserDTO form) {
		String encrytedPassword = this.passwordEncoder.encode(form.getPassword());
		AppUser user = new AppUser(form.getUserName(), //
				encrytedPassword, true, form.getFirstName(), form.getLastName(), form.getEmail());
		appUserRepository.save(user);
		return user;
	}

	@Override
	public AppUser checkUserName(String userName) {
		AppUser appUser = new AppUser();
		appUser = appUserRepository.findUserByUserName(userName);
		return appUser;
	}

	@Override
	public AppUser checkUserEMail(String email) {
		AppUser appUser = new AppUser();
		appUser = appUserRepository.findUserByEmail(email);
		return appUser;
	}

	@Override
	public List<AppUser> getAllUser() {
		return (List<AppUser>) appUserRepository.findAll();
	}

	@Override
	public Optional<AppUser> getUserById(long id) {
		Optional<AppUser> optional = appUserRepository.findById((int) id);
		return optional;
	}

	@Override
	public void updateUser(AppUser appUser) {
		appUserRepository.save(appUser);

	}

  @Override
  public List<AppUser> managementUser() {
    return appUserRepository.managermentUser();
  }
  @Override
  public void deleteUserById(int id) {
    appUserRepository.deleteById(id);
    
  }

//  @Override
//  public void deleteManageUser(Long id) {
//   appUserRepository.deleteManagerUser(id);
//    
//  }
//
//  @Override
//  public void deleteManageUserRole(Long id) {
//   appUserRepository.deleteManagerUserRole(id);
//    
//  }
  

}
