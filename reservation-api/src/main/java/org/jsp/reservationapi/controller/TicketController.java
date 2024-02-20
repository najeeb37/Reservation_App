package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.dto.Ticket;
import org.jsp.reservationapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
	@Autowired
	public TicketService service;
	
	@PostMapping("/tickets/{user_id}/{bus_id}")
	public ResponseEntity<ResponseStructure<Ticket>> bookTicket(@RequestBody Ticket ticket,@PathVariable int user_id,@PathVariable int bus_id){
		return service.saveTicket(ticket, user_id, bus_id);
	}
}
