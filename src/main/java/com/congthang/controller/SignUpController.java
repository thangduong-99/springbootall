package com.congthang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.congthang.dto.AppUserDTO;
import com.congthang.entity.AppRole;
import com.congthang.entity.AppUser;
import com.congthang.service.AppRoleService;
import com.congthang.service.AppUserService;
import com.congthang.service.UserRoleService;
import com.congthang.validator.AppUserValidator;

@Controller
public class SignUpController {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private AppUserValidator appUserValidator;

	@Autowired
	private AppRoleService appRoleService;

	@Autowired
	private UserRoleService userRoleService;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		// Form target
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == AppUserDTO.class) {
			dataBinder.setValidator(appUserValidator);
		}
		// ...
	}

	@RequestMapping("/")
	public String viewHome(Model model) {

		return "welcomePage";
	}

	@RequestMapping("/members")
	public String viewMembers(Model model) {

		return "membersPage";
	}

	@RequestMapping("/registerSuccessful")
	public String viewRegisterSuccessful(Model model) {

		return "registerSuccessfulPage";
	}

	// Show Register page.
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegister(Model model) {

		AppUserDTO form = new AppUserDTO();

		model.addAttribute("appUserForm", form);

		return "registerPage";
	}

	// This method is called to save the registration information.
	// @Validated: To ensure that this Form
	// has been Validated before this method is invoked.
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveRegister(Model model, //
			@ModelAttribute("appUserForm") @Validated AppUserDTO appUserForm, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {

		// Validate result
		if (result.hasErrors()) {
			return "registerPage";
		}
		AppUser newUser = null;
		AppRole appRole = null;
		try {
			String USER_NAME = appUserForm.getUserName();
			String email = appUserForm.getEmail();
			if (appUserService.checkUserName(USER_NAME) == null || appUserService.checkUserEMail(email) == null) {
				newUser = appUserService.createAppUser(appUserForm);
				appRole = appRoleService.creatAppRole();
				userRoleService.creatUserRole(appRole.getRoleId(), newUser.getUserId());
			} else {
				System.out.println("trung username");
				model.addAttribute("errorMessage", "UserName or PassWord already exist ! Please check again !");
				return "registerPage";
			}
		}
		// Other error!!
		catch (Exception e) {
			model.addAttribute("errorMessage", "Error: " + e.getMessage());
			return "registerPage";
		}

		redirectAttributes.addFlashAttribute("flashUser", newUser);

		return "redirect:/registerSuccessful";
	}

}
