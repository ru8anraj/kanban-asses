package com.ru8anraj.kanban.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ru8anraj.kanban.model.Ticket;
import com.ru8anraj.kanban.model.Ticket.StatusEnum;
import com.ru8anraj.kanban.service.TicketService;

import io.swagger.annotations.ApiParam;

@RestController
public class TicketApiController implements TicketApi {

	private static final Logger log = LoggerFactory.getLogger(TicketApiController.class);

	@Autowired
	TicketService ticketService;

	public ResponseEntity<String> addTicket(
			@ApiParam(value = "Ticket object that needs to be added to the kanban", required = true) @Valid @RequestBody Ticket body) {
		if(ticketService.addTicket(body)) {
			return new ResponseEntity<String>("Successfully added the ticket!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	public ResponseEntity<String> deleteTicket(
			@ApiParam(value = "Ticket id to delete", required = true) @PathVariable("ticketId") Long ticketId) {
		if(ticketService.deleteTicket(ticketId)) {
			return new ResponseEntity<String>("Successfully deleted the ticket!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<List<Ticket>> findAllTickets() {
		try {
			List<Ticket> ticketsList = ticketService.getAllTicket();
			if(ticketsList.size() == 0) {
				return new ResponseEntity<List<Ticket>>(ticketsList, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<Ticket>>(ticketsList, HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<List<Ticket>> findTicketsByStatus(
			@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "Backlog, Work In Progress, Completed") @Valid @RequestBody(required = true) List<StatusEnum> status) {
		try {
			List<Ticket> ticketsList = ticketService.getAllTicketByStatus(status);
			if(ticketsList.size() == 0) {
				return new ResponseEntity<List<Ticket>>(ticketsList, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<Ticket>>(ticketsList, HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Ticket> getTicketById(
			@ApiParam(value = "ID of ticket to return", required = true) @PathVariable("ticketId") Long ticketId) {
		try {
			Ticket ticket = ticketService.getAllTicketById(ticketId);
			if (ticket != null) {
				return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);				
			} else {
				return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<String> updateTicket(
			@ApiParam(value = "ID of ticket to return", required = true) @PathVariable("ticketId") Long ticketId,
			@ApiParam(value = "Ticket object that needs to be added to the kanban", required = true) @Valid @RequestBody Ticket body) {
		if(ticketService.updateTicket(ticketId, body)) {
			return new ResponseEntity<String>("Successfully updated the ticket!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
		}
	}

}
