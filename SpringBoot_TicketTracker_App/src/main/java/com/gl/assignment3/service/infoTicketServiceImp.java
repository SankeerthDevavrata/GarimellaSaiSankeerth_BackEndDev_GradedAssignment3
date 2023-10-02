package com.gl.assignment3.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.assignment3.model.infoTicket;
import com.gl.assignment3.repository.repositorySpring;



@Service
public class infoTicketServiceImp implements infoTicketService {

	@Autowired
	repositorySpring ticketRepository;
	
	public List<infoTicket> getAllTicket() {
		return ticketRepository.findAll();
	}

	public infoTicket saveTicket(infoTicket ticket) {
		ticket.setTicketCreatedDate(LocalDate.now());
		return ticketRepository.save(ticket);

	}

	public infoTicket getTicketByID(int id) {
		return ticketRepository.findById(id).get();
	}

	public infoTicket updateTicket(int id, infoTicket ticket) {
		infoTicket ticketUpdate = getTicketByID(id);
		ticketUpdate.setTicketTitle(ticket.getTicketTitle());
		ticketUpdate.setTicketShortDescription(ticket.getTicketShortDescription());
//		ticketUpdate.setTicketCreatedDate(ticket.getTicketCreatedDate());
		return saveTicket(ticket);
	}

	public void deleteTicketByID(int id) {
		ticketRepository.deleteById(id);
	}
	
	public infoTicket getTicketByTitle(String title) {
		return ticketRepository.findByTicketTitle(title);
	}

}
