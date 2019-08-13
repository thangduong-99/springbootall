package com.congthang.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.congthang.dto.AppUserDTO;
import com.congthang.entity.AppUser;
import com.congthang.service.AppUserService;
import com.congthang.service.impl.UserDetailsServiceImpl;
import com.congthang.utils.WebUtils;

@Controller
public class MainController {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		return "adminPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "loginPage";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();

		System.out.println("User Name: " + userName);

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);

		AppUser appUser = userDetailsServiceImpl.informationUser(userName);
		model.addAttribute("member", appUser);

		return "userInfoPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			String userInfo = WebUtils.toString(loginedUser);

			model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "403Page";
	}

	@RequestMapping(value = "/editUser/{userName}", method = RequestMethod.GET)
	public ModelAndView editInfor(@PathVariable("userName") String userName) {
		ModelAndView view = new ModelAndView("edit_user");

		AppUser appUser = userDetailsServiceImpl.informationUser(userName);
		int id = Integer.parseInt(Long.toString(appUser.getUserId()));
		AppUserDTO appUserDTO = new AppUserDTO(id, appUser.getUserName(), appUser.getFirstName(), appUser.getLastName(),
				appUser.getEmail(), "", "");
		view.addObject("userForm", appUserDTO);

		return view;
	}

	@RequestMapping(value = "/saveEditUser", method = RequestMethod.POST)
	public String saveEditUser(Model model, @ModelAttribute("userForm") @Validated AppUserDTO appUserDTO,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "edit_user";
		}

		try {
			String passWord = encoder.encode(appUserDTO.getConfirmPassword());
			AppUser appUser = new AppUser((long) appUserDTO.getUserId(), appUserDTO.getUserName(), passWord, true,
					appUserDTO.getFirstName(), appUserDTO.getLastName(), appUserDTO.getEmail());
			if(appUserDTO.getPassword().equals(appUserDTO.getConfirmPassword()) && appUserDTO.getPassword()!=null && appUserDTO.getConfirmPassword()!=null) {
				appUserService.updateUser(appUser);
			}
			
		}
		// Other error!!
		catch (Exception e) {
			model.addAttribute("errorMessage", "Error: " + e.getMessage());
			return "edit_user";
		}

		redirectAttributes.addFlashAttribute("flashUser", appUserDTO);

		return "redirect:/userInfo";
	}
}
