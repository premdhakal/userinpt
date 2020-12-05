package com.springproject.empty.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.empty.Form.HomeForm;
import com.springproject.empty.Service.HomeService;

@Controller
public class HomeController {

	private HomeService homeService;
	
	//Create a service class Constructor
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("/home")
	public String getHomePage(@ModelAttribute("newCar") HomeForm newCar, Model model) {
		model.addAttribute("carsList", this.homeService.getCars());
		return "index";
	}
	
	@PostMapping("/home")
	public String addCar(@ModelAttribute("newCar") HomeForm homeForm, Model model) {
		homeService.addNewCar(homeForm.getCarName());
		model.addAttribute("carsList", homeService.getCars());
		homeForm.setCarName("");
		return "index";
	}
}
