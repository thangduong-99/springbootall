package com.congthang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.congthang.entity.AppUser;
import com.congthang.repository.AppUserDAO;
import com.congthang.service.impl.UserDetailsServiceImpl;

@RestController
public class TestController {

  @Autowired
  private AppUserDAO appUserDAO;
  @Autowired
  private UserDetailsServiceImpl impl;

  @RequestMapping(value = "/test/{userName}", method = RequestMethod.GET)
  public ResponseEntity<AppUser> entity(@PathVariable("userName") String userName) {
    AppUser appUser = appUserDAO.findUserAccount(userName);
    if (appUser == null) {
      return new ResponseEntity<AppUser>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
  }

  @RequestMapping(value = "/infor/{userName}")
  public ResponseEntity<AppUser> informationUser(@PathVariable("userName") String userName) {
    AppUser appUser = impl.informationUser(userName);
    if (appUser == null) {
      return new ResponseEntity<AppUser>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
  }
}
