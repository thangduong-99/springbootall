package com.congthang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.congthang.entity.AppRole;
@Repository
public interface AppRoleRepository extends CrudRepository<AppRole, Long>{

}
