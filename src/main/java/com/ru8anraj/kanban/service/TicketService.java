package com.ru8anraj.kanban.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ru8anraj.kanban.entity.TicketEntity;
import com.ru8anraj.kanban.model.Ticket;
import com.ru8anraj.kanban.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;

	public void addTicket(@Valid Ticket body) {
		try {
			TicketEntity ticketEntity = new TicketEntity();
			ticketEntity.setTitle(body.getTitle());
			ticketEntity.setStatus(body.getStatus());
			ticketEntity.setAssignedTo(body.getAssignedTo());
			ticketEntity.setCreatedOn(body.getCreatedOn());
			
			ticketRepository.save(ticketEntity);
		} catch (Exception e) {
			
		}
	}
	
	public List<Ticket> getAllTicket() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		ticketRepository.findAll().forEach(ticket -> {
			Ticket ticketModel = new Ticket();
			ticketModel.setId(ticket.getId());
			ticketModel.setTitle(ticket.getTitle());
			ticketModel.setStatus(ticket.getStatus());
			ticketModel.setAssignedTo(ticket.getAssignedTo());
			ticketModel.setCreatedOn(ticket.getAssignedTo());
			tickets.add(ticketModel);
		});
        return tickets;
	}

}
