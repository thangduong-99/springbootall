package com.congthang.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.congthang.entity.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
	@Query(value = "SELECT * FROM App_User WHERE USER_NAME = :userName", nativeQuery = true)
	public AppUser findUserByUserName(@Param("userName") String userName);

	@Query(value = "SELECT * FROM App_User WHERE EMAIL = :email", nativeQuery = true)
	public AppUser findUserByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM app_user WHERE app_user.USER_ID IN (SELECT user_role.USER_ID FROM user_role WHERE user_role.ROLE_ID = 2)",nativeQuery = true)
	public List<AppUser> managermentUser();
	
//	@Transactional
//	@Modifying
//	@Query(value = "DELETE FROM app_user WHERE app_user.USER_ID = :id",nativeQuery = true)
//	public void deleteManagerUser(@Param("id") Long id);
//	
//	@Transactional
//    @Modifying
//    @Query(value = "DELETE FROM user_role WHERE user_role.USER_ID = :id",nativeQuery = true)
//    public void deleteManagerUserRole(@Param("id") Long id);
	
}
