package com.congthang.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.congthang.entity.AppUser;
import com.congthang.service.AppUserService;

@Controller
public class AdminController {

  @Autowired
  private AppUserService appUserService;
  
  
  
  @RequestMapping(value = "/managementUser", method = RequestMethod.GET)
  public String managementListUser(Model model) {
    List<AppUser> appUsers = appUserService.managementUser();
    model.addAttribute("listUser",appUsers);
    return "personList";
  }
  
  @Transactional
  @RequestMapping(value = "/delete/{id}")
  public String deleteUser(@PathVariable(name = "id") Long id) {
//  appUserService.deleteManageUser(id);
//  appUserService.deleteManageUserRole(id);
  return "redirect:/managementUser";
}
  
}
