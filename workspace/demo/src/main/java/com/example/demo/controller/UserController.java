package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserRepository;
import com.example.demo.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	private HttpServletResponse response;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpSession session;

	@Autowired
	private UserRepository ur;

	@RequestMapping("/UserAdd")
	public ModelAndView UserAdd() {
		return new ModelAndView("UserAdd");

	}

	@RequestMapping("/UserLogin")
	public ModelAndView UserLogin() {
		return new ModelAndView("UserLogin");

	}

	@RequestMapping("login")
	public ModelAndView login(@RequestBody User u) {
		User l = ur.queryUser(u.getUserName(), u.getPassword());

		if (l != null) {
			session.setAttribute("M", l);
			ModelAndView mav = new ModelAndView("index");
			return mav;
		} else {
			return new ModelAndView("redirect:ErrorLogin");
		}
	}

	@RequestMapping("logout")
	public ModelAndView logout() {
		session.removeAttribute("M");
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping("User")
	public ModelAndView User() {
		ModelAndView mav = new ModelAndView("user");
		return mav;
	}

	@RequestMapping(value = "AddUser", method = RequestMethod.POST)
	public ModelAndView AddUser(@ModelAttribute User u) {
		User l = ur.queryUserName(u.getUserName());
		if (l != null) {
			return new ModelAndView("redirect:UserAddError");
		} else {
			ur.save(u);
			return new ModelAndView("UserLogin");
		}
	}

	@RequestMapping("/PasswordUpdate")
	public ModelAndView PasswordUpdate(@ModelAttribute("Password") String Password)
	{
		User m = (User) session.getAttribute("M1");
		m.setPassword(Password);
		ur.save(m);
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping("/UserConfirm")
	public ModelAndView UserConfirm(@ModelAttribute("UserName") String UserName) {
		User u = ur.queryUserName(UserName);
		if (u != null) {
			session.setAttribute("M1", u);
			ModelAndView cm = new ModelAndView("PasswordUpdate");
			return cm;

		} else {

			return new ModelAndView("redirect:PasswordUpdateError");
		}
	}

	@RequestMapping("PasswordConfirm")
	public ModelAndView PasswordConfirm() {
		ModelAndView cp = new ModelAndView("PasswordUpdate");
		return cp;
	}

	@RequestMapping("UserUpdate")
	public ModelAndView UserUpdate() {
		ModelAndView mav = new ModelAndView("UserUpdate");
		return mav;
	}

	@RequestMapping("ErrorLogin")
	public String ErrorLogin() {
		return "帳號密碼錯誤請重新輸入,若無帳號請先註冊";
	}

	@RequestMapping("UserAddError")
	public String AddUserError() {
		return "帳號重複請重新註冊";
	}

	@RequestMapping("PasswordUpdateError")
	public String updatepasswordError() {
		return "無此帳號請重新輸入";
	}
}
