package com.ru8anraj.kanban.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ru8anraj.kanban.controller.TicketApiController;
import com.ru8anraj.kanban.entity.TicketEntity;
import com.ru8anraj.kanban.model.Ticket;
import com.ru8anraj.kanban.repository.TicketRepository;

@Service
public class TicketService {
	
	private static final Logger log = LoggerFactory.getLogger(TicketApiController.class);
	
	@Autowired
	TicketRepository ticketRepository;

	public boolean addTicket(@Valid Ticket body) {
		try {
			TicketEntity ticketEntity = new TicketEntity();
			ticketEntity.setTitle(body.getTitle());
			ticketEntity.setStatus(body.getStatus());
			ticketEntity.setAssignedTo(body.getAssignedTo());
			ticketEntity.setCreatedOn(body.getCreatedOn());
			
			ticketRepository.save(ticketEntity);
			return true;
		} catch (Exception e) {
			log.error("Couldn't save ticket to the DB!", e);
			return false;
		}
	}
	
	public List<Ticket> getAllTicket() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			ticketRepository.findAll().forEach(ticket -> {
				Ticket ticketModel = new Ticket();
				ticketModel.setId(ticket.getId());
				ticketModel.setTitle(ticket.getTitle());
				ticketModel.setStatus(ticket.getStatus());
				ticketModel.setAssignedTo(ticket.getAssignedTo());
				ticketModel.setCreatedOn(ticket.getCreatedOn());
				tickets.add(ticketModel);
			});
	        return tickets;
		} catch (Exception e) {
			log.error("Error in fetching tickets from DB!", e);
			return tickets;
		}	
	}

	public boolean deleteTicket(Long ticketId) {
		try {
			ticketRepository.deleteById(ticketId);
			return true;
		} catch (Exception e) {
			log.error("Couldn't delete the ticket from the DB!", e);
			return false;
		}
	}

	public List<Ticket> getAllTicketByStatus(@NotNull @Valid List<String> status) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			return tickets;
		} catch (Exception e) {
			log.error("Error in fetching tickets for the selected status", status, e);
			return tickets;
		}
	}

	public Ticket getAllTicketById(Long ticketId) {
		Ticket ticket = new Ticket();
		try {
			Optional<TicketEntity> ticketEntity = ticketRepository.findById(ticketId);
			ticket.setId(ticketEntity.get().getId());
			ticket.setTitle(ticketEntity.get().getTitle());
			ticket.setStatus(ticketEntity.get().getStatus());
			ticket.setAssignedTo(ticketEntity.get().getAssignedTo());
			ticket.setCreatedOn(ticketEntity.get().getCreatedOn());
			return ticket;
		} catch (Exception e) {
			log.error("Error in fetching tickets for the given ticketId", ticketId, e);
			return ticket;
		}
	}

	public boolean updateTicket(Long ticketId, @Valid Ticket body) {
		try {
			TicketEntity ticketEntity = new TicketEntity();
			ticketEntity.setTitle(body.getTitle());
			ticketEntity.setStatus(body.getStatus());
			ticketEntity.setAssignedTo(body.getAssignedTo());
			ticketEntity.setCreatedOn(body.getCreatedOn());
			
//			ticketRepository.updateTicketWithId(ticketId, ticketEntity);
			return true;
		} catch (Exception e) {
			log.error("Couldn't update the ticket in the DB!",ticketId, e);
			return false;
		}
	}

}
