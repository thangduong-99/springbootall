package com.congthang.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.congthang.service.ProductService;

@Controller
public class CustomerController {
  
  @Autowired
  ProductService productService;

  @RequestMapping(value = "/shopping",method = RequestMethod.GET)
  public String shoppingCustomer(Model model,Principal principal) {
    return "";
    
  }
}
