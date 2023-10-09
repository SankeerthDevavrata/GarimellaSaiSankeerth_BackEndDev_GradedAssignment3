package com.gl.assignment3.service;

import java.util.List;

import com.gl.assignment3.model.infoTicket;

public interface infoTicketService {

	List<infoTicket> getAllTicket();

	infoTicket saveTicket(infoTicket ticket);

	infoTicket getTicketByID(int id);

	infoTicket updateTicket(int id, infoTicket ticket);

	void deleteTicketByID(int id);
	
}
