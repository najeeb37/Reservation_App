package org.jsp.reservationapi.dao;

import org.jsp.reservationapi.dto.Ticket;
import org.jsp.reservationapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao {
	@Autowired
	private TicketRepository repository;

	public Ticket saveTicket(Ticket ticket) {
		return repository.save(ticket);
	}
	
}
