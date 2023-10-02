package com.gl.assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.assignment3.model.infoTicket;


@Repository
public interface repositorySpring extends JpaRepository<infoTicket, Integer> {
	infoTicket findByTicketTitle(String title);
}
