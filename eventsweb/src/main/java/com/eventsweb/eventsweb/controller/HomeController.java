package com.eventsweb.eventsweb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	public HomeController() {
	}

	@RequestMapping({"/"})
	public String home() {
		return "home";
	}

	@RequestMapping({"/login"})
	public String login(@RequestParam(value = "error",required = false) String error, @RequestParam(value = "logout",required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Some error");
		}

		if (logout != null) {
			model.addAttribute("msg", "message");
		}

		return "login";
	}
}
