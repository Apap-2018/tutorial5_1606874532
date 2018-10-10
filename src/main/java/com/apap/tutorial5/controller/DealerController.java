package com.apap.tutorial5.controller;

import java.util.List;

import com.apap.tutorial5.model.*;
import com.apap.tutorial5.repository.DealerDb;
import com.apap.tutorial5.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DealerController {
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("dealer", new DealerModel());
		return "addDealer";
	}
	
	@RequestMapping(value = "dealer/add", method = RequestMethod.POST)
	private String addDealerSubmit(@ModelAttribute DealerModel dealer) {
		dealerService.addDealer(dealer);
		return "add";
	}
	
	@RequestMapping(value = "dealer/view" , method = RequestMethod.GET)
	private String viewDealer(@RequestParam ("dealerId") long dealerId, Model model) {
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		dealer.setListCar(carService.sortByPriceDesc(dealerId));
		model.addAttribute("dealer", dealer);
		return "view";
	}
	
	@RequestMapping(value = "/dealer/delete", method = RequestMethod.GET)
	private String deleteDealer(@RequestParam("dealerId") long id, Model model) {
		Optional<DealerModel> dealer = dealerService.getDealerDetailById(id);
		if (dealer.isPresent()) {
			dealerService.deleteDealer(dealer.get());
			return "delete";
		}
		return "error";
	}
	
	@RequestMapping(value = "/dealer/update/{id}", method = RequestMethod.GET)
	private String updateDealer(@PathVariable(value = "id") long id, Model model) {
		DealerModel dealer = dealerService.getDealerDetailById(id).get();
		model.addAttribute("dealer",dealer);
		return "updateDealer";
	}
	
	@RequestMapping(value = "/dealer/update/{id}", method = RequestMethod.POST)
	private String updateDealerSubmit(@PathVariable (value = "id") long id, @ModelAttribute Optional<DealerModel> dealer) {
		if(dealer.isPresent()) {
			dealerService.updateDealer(id, dealer);
			return "update";
		}
		return "error";
	}
	
	@RequestMapping(value = "/dealer/view/all", method = RequestMethod.GET)
	private String viewAllDealer(Model model) { 
		DealerDb dealerRepo = dealerService.viewAllDealer();
		List<DealerModel> listDealer = dealerRepo.findAll();
		model.addAttribute("listDealer",listDealer);
		
		return "allDealer";
	}
}
