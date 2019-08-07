package com.congthang.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.congthang.entity.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
	@Query(value = "SELECT * FROM App_User WHERE USER_NAME = :userName", nativeQuery = true)
	public AppUser findUserByUserName(@Param("userName") String userName);

	@Query(value = "SELECT * FROM App_User WHERE EMAIL = :email", nativeQuery = true)
	public AppUser findUserByEmail(@Param("email") String email);

}
