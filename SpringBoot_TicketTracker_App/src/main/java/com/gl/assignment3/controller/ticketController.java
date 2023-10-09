package com.gl.assignment3.controller;

//import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.assignment3.model.infoTicket;
import com.gl.assignment3.service.infoTicketServiceImp;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ticketController {

	@Autowired
	infoTicketServiceImp ticketService;
	
	@GetMapping("/")
	private String HomePage() {
		return "home";
	}
	
	@GetMapping("/tickets")
	private String listTicketss(Model model) {
		model.addAttribute("tickets",ticketService.getAllTicket());
		return "tickets";
	}
	
	@GetMapping("/tickets/new")
	private String createEmployees(Model model) {
		infoTicket tickets = new infoTicket();
		model.addAttribute("ticket",tickets);
		return "create_ticket";
	}
	
	@PostMapping("/tickets")
	private String saveEmployees(@ModelAttribute("employee") infoTicket ticket ) {
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}
	
	@GetMapping("/tickets/edit/{id}")
	private String editTickets(@PathVariable int id , Model model) {
		model.addAttribute("ticket",ticketService.getTicketByID(id));
		return "edit_ticket";
	}
	
	@PostMapping("/tickets/{id}")
	private String updateTicketById(@PathVariable int id ,@ModelAttribute("employee") infoTicket ticket ,Model model) {
		ticketService.updateTicket(id, ticket);
		return "redirect:/tickets";
	}
	
	@GetMapping("/tickets/{id}")
	private String deleteEmployeeById(@PathVariable int id) {
		ticketService.deleteTicketByID(id);
		return "redirect:/tickets";
	}
	
//	@PostMapping("/tickets/search")
//    private String searchTickets(@RequestParam String ticketSearch, Model model) {
//        infoTicket ticket = ticketService.getTicketByTitle(ticketSearch);
//        if (ticket != null) {
//            model.addAttribute("tickets", Collections.singletonList(ticket));
//        } else {
//            model.addAttribute("tickets", Collections.emptyList());
//        }
//        return "search-tickets";
//    }
	
	@PostMapping("/tickets/search")
	private String searchTicketsByBoth(@RequestParam String ticketSearch, Model model) {
	    List<infoTicket> tickets = ticketService.searchByTitleOrDescription(ticketSearch);
	    
	    model.addAttribute("tickets", tickets);
	    return "search-tickets";
	}

	
	@GetMapping("/tickets/view/{id}")
	private String viewTickets(@PathVariable int id , Model model) {
		model.addAttribute("ticket",ticketService.getTicketByID(id));
		return "view-ticket";
	}
	
}
