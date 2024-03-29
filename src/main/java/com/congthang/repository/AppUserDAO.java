package com.congthang.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.congthang.dto.AppUserDTO;
import com.congthang.entity.AppUser;

@Repository
@Transactional
public class AppUserDAO {

	@Autowired
	private EntityManager entityManager;

	public AppUser findUserAccount(String userName) {
		try {
			String sql = "Select e from " + AppUser.class.getName() + " e " //
					+ " Where e.userName = :userName ";

			Query query = entityManager.createQuery(sql, AppUser.class);
			query.setParameter("userName", userName);

			return (AppUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final Map<Long, AppUser> USERS_MAP = new HashMap<>();
	public Long getMaxUserId() {
		long max = 0;
		for (Long id : USERS_MAP.keySet()) {
			if (id > max) {
				max = id;
			}
		}
		return max;
	}

	//

	public AppUser findAppUserByUserName(String userName) {
		Collection<AppUser> appUsers = USERS_MAP.values();
		for (AppUser u : appUsers) {
			if (u.getUserName().equals(userName)) {
				return u;
			}
		}
		return null;
	}

	public AppUser findAppUserByEmail(String email) {
		Collection<AppUser> appUsers = USERS_MAP.values();
		for (AppUser u : appUsers) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}

	public List<AppUser> getAppUsers() {
		List<AppUser> list = new ArrayList<>();

		list.addAll(USERS_MAP.values());
		return list;
	}

	public AppUser createAppUser(AppUserDTO form) {
		Long userId = this.getMaxUserId() + 1;
		String encrytedPassword = this.passwordEncoder.encode(form.getPassword());

		AppUser user = new AppUser(form.getUserName(), //
				encrytedPassword, true, form.getFirstName(), form.getLastName(),
				form.getEmail());

		USERS_MAP.put(userId, user);
		return user;
	}
    

}