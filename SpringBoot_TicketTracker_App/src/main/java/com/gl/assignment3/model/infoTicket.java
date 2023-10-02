package com.gl.assignment3.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ticket_Infomation")
public class infoTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column(name="ticket_Title")
	private String ticketTitle;
	
	@Column(name="ticket_Short_Description")
	private String ticketShortDescription;
	
	@Column(name="ticket_Created_Date")
	private LocalDate ticketCreatedDate;
	
	@Column(name="ticket_Content")
	private String ticketContent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.ticketCreatedDate=LocalDate.now();
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketShortDescription() {
		return ticketShortDescription;
	}

	public void setTicketShortDescription(String ticketShortDescription) {
		this.ticketShortDescription = ticketShortDescription;
	}

	public LocalDate getTicketCreatedDate() {
		return ticketCreatedDate;
	}

	public void setTicketCreatedDate(LocalDate ticketCreatedDate) {
		this.ticketCreatedDate = ticketCreatedDate;
	}

	public infoTicket(String ticketTitle, String ticketShortDescription,LocalDate ticketCreatedDate,String ticketContent) {
		this.ticketCreatedDate=LocalDate.now();
		this.ticketTitle = ticketTitle;
		this.ticketShortDescription = ticketShortDescription;
		this.ticketContent=ticketContent;
	}

	public infoTicket() {
		super();
	}
	
	public String getFormattedTicketCreatedDate() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
	    return ticketCreatedDate.format(formatter);
	}

	public String getTicketContent() {
		return ticketContent;
	}

	public void setTicketContent(String ticketContent) {
		this.ticketContent = ticketContent;
	}

	
}
