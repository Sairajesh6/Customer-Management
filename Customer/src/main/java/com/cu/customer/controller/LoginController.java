package com.cu.customer.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cu.customer.entity.Login;
import com.cu.customer.repository.LoginRepository;

@Controller
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping("/Login")
	public String userLogin(Model model) throws IOException {
		Login login = new Login();
		model.addAttribute("login", login);
		return "Login";
	}
	@PostMapping("/customerLogin")
	public String loginUser(@ModelAttribute("login") Login login, Model model) {
		String logId = login.getId();
		String password = login.getPassword();
		
		Optional<Login> loginid=loginRepository.findById(logId);
		Login login1 = loginid.get();
		if (login1 != null) {
			if (logId.equals(login1.getId()) && password.equals(login1.getPassword())) 
			{

				return "redirect:/customerlist";
			} 
			else {
				model.addAttribute("error", "password wrong");
				return "Login";
			}
		} else {
			model.addAttribute("error", "Invalid Username");
			return "Login";
		}
		
	}
	
}
