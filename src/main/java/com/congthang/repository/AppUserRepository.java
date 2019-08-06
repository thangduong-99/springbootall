package com.congthang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.congthang.entity.AppUser;
@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer>{

}
