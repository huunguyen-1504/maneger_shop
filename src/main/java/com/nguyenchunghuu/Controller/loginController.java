package com.nguyenchunghuu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenchunghuu.Entity.User;
import com.nguyenchunghuu.service.UserService;

@Controller
@RequestMapping("/login")
@SessionAttributes("unames")
public class loginController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping
	public String loginFormDefault() {
		return "login";
	}
	
	@PostMapping
	public String signin(@RequestParam String email, @RequestParam String fullname, @RequestParam String uname, @RequestParam String psw, @RequestParam String cpsw, ModelMap modelMap) {
		if(psw.equals(cpsw)) {
			User user = new User();
			user.setGmail(email);
			user.setHoVaTen(fullname);
			user.setUserName(uname);
			user.setPasswords(psw);
			user.setIdUser(2);
			
			boolean ktraADD = userservice.addUser(user);
			if(ktraADD == true) {
				modelMap.addAttribute("succsess", "Đăng kí thành công!");
				return "login";
			} else {
				modelMap.addAttribute("succsess", "Đăng kí thất bại!");
				return "login";
			}
		} else {
			modelMap.addAttribute("succsess", "Nhập mật khẩu không trùng khớp!");
			return "login";
		}		
	}
}
