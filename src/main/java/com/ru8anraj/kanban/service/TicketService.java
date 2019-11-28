package com.ru8anraj.kanban.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ru8anraj.kanban.controller.TicketApiController;
import com.ru8anraj.kanban.entity.TicketEntity;
import com.ru8anraj.kanban.model.Ticket;
import com.ru8anraj.kanban.model.Ticket.StatusEnum;
import com.ru8anraj.kanban.repository.TicketRepository;

@Service
@Transactional
public class TicketService {
	
	private static final Logger log = LoggerFactory.getLogger(TicketApiController.class);
	
	@Autowired
	private TicketRepository ticketRepository;

	public boolean addTicket(@Valid Ticket body) {
		if (body == null) { 
			throw new RuntimeException ("Data passed cannot be null");
		}
		try {
			TicketEntity ticketEntity = new TicketEntity();
			BeanUtils.copyProperties(body, ticketEntity, "id");
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
				BeanUtils.copyProperties(ticket, ticketModel);
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

	public List<Ticket> getAllTicketByStatus(@NotNull @Valid List<StatusEnum> status) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			if (status.size() != 0 && status.size() == 1){
				ticketRepository.findAllWithStatus(status.get(0)).forEach(ticket -> {
					Ticket ticketModel = new Ticket();
					BeanUtils.copyProperties(ticket, ticketModel);
					tickets.add(ticketModel);
				});
			}
			
			if (status.size() != 0 && status.size() == 2) {
				ticketRepository.findAllWithStatus(status.get(0), status.get(1)).forEach(ticket -> {
					Ticket ticketModel = new Ticket();
					BeanUtils.copyProperties(ticket, ticketModel);
					tickets.add(ticketModel);
				});
			}
			if (status.size() != 0 && status.size() == 3) {
				ticketRepository.findAllWithStatus(status.get(0), status.get(1), status.get(2)).forEach(ticket -> {
					Ticket ticketModel = new Ticket();
					BeanUtils.copyProperties(ticket, ticketModel);
					tickets.add(ticketModel);
				});
			}
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
			TicketEntity entity = ticketEntity.get();
			if ( entity == null ) {
				log.error("Couldn't find the ticket in the DB with id {}!",ticketId);
				return null;
			}
			BeanUtils.copyProperties(entity, ticket);
			return ticket;
		} catch (Exception e) {
			log.error("Error in fetching tickets for the given ticketId", ticketId, e);
			return ticket;
		}
	}

	
	public boolean updateTicket(Long ticketId, @Valid Ticket body) {
		try {
			Optional<TicketEntity> ticketEntity = ticketRepository.findById(ticketId);
			TicketEntity entity = ticketEntity.get();
			if ( entity == null ) {
				log.error("Couldn't find the ticket in the DB with id {}!",ticketId);
				return false;
			}
			BeanUtils.copyProperties(body, entity, "id");
			ticketRepository.save(entity);
			return true;
		} catch (Exception e) {
			log.error("Couldn't update the ticket in the DB!",ticketId, e);
			return false;
		}
	}

}
