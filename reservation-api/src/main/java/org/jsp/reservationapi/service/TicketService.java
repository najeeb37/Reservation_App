package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.BusDao;
import org.jsp.reservationapi.dao.TicketDao;
import org.jsp.reservationapi.dao.UserDao;
import org.jsp.reservationapi.dto.Bus;
import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.dto.Ticket;
import org.jsp.reservationapi.dto.User;
import org.jsp.reservationapi.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	@Autowired
	private TicketDao dao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BusDao busDao;
	
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket ticket,int user_id,int bus_id){
		Optional<Bus> recBus = busDao.findById(bus_id);
		Optional<User> recUser = userDao.findById(bus_id);
		
		ResponseStructure<Ticket> structure = new ResponseStructure<>();
		if(recBus.isPresent() && recUser.isPresent()) {
			recBus.get().getTickets().add(ticket);
			recUser.get().getTickets().add(ticket);
			structure.setData(dao.saveTicket(ticket));
			userDao.updateUser(recUser.get());
			busDao.updateBus(recBus.get());
			structure.setMessege("Ticket Booking Succesfull");
			structure.setStstusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.CREATED);
			
		}
		throw new IdNotFoundException();
	}
}
