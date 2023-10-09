package com.gl.assignment3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.assignment3.model.infoTicket;


@Repository
public interface repositorySpring extends JpaRepository<infoTicket, Integer> {
	infoTicket findByTicketTitle(String title);
	List<infoTicket> findByTicketTitleContainingOrTicketShortDescriptionContaining(String title, String description);
}
