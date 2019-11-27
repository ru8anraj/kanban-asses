package com.ru8anraj.kanban.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.ru8anraj.kanban.model.Ticket;
import com.ru8anraj.kanban.model.Ticket.StatusEnum;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-27T15:43:52.640Z")

@Controller
public class TicketApiController implements TicketApi {

	private static final Logger log = LoggerFactory.getLogger(TicketApiController.class);

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public TicketApiController(HttpServletRequest request) {
		this.request = request;
	}

	public ResponseEntity<Void> addTicket(
			@ApiParam(value = "Ticket object that needs to be added to the kanban", required = true) @Valid @RequestBody Ticket body) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> deleteTicket(
			@ApiParam(value = "Ticket id to delete", required = true) @PathVariable("ticketId") Long ticketId,
			@ApiParam(value = "") @RequestHeader(value = "api_key", required = false) String apiKey) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Ticket>> findAllTickets() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				List<Ticket> ticketsList = new ArrayList<Ticket>();
				Ticket ticket = new Ticket();
				ticket.setId(3456779L);
				ticket.setTitle("New Ticket");
				ticket.setCreatedOn(LocalDate.now());
				ticket.setAssignedTo("Rubanraj");
				ticket.setStatus(StatusEnum.BACKLOG);
				ticketsList.add(ticket);
				return new ResponseEntity<List<Ticket>>(ticketsList, HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Ticket>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Ticket>> findTicketsByStatus(
			@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "available, pending, sold") @Valid @RequestParam(value = "status", required = true) List<String> status) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				List<Ticket> ticketsList = new ArrayList<Ticket>();
				Ticket ticket = new Ticket();
				ticket.setId(3456779L);
				ticket.setTitle("New Ticket");
				ticket.setCreatedOn(LocalDate.now());
				ticket.setAssignedTo("Rubanraj");
				ticket.setStatus(StatusEnum.BACKLOG);
				ticketsList.add(ticket);
				return new ResponseEntity<List<Ticket>>(ticketsList, HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Ticket>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Ticket> getTicketById(
			@ApiParam(value = "ID of ticket to return", required = true) @PathVariable("ticketId") Long ticketId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				Ticket ticket = new Ticket();
				ticket.setId(3456779L);
				ticket.setTitle("New Ticket");
				ticket.setCreatedOn(LocalDate.now());
				ticket.setAssignedTo("Rubanraj");
				ticket.setStatus(StatusEnum.BACKLOG);
				return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Ticket>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> updateTicket(
			@ApiParam(value = "ID of ticket to return", required = true) @PathVariable("ticketId") Long ticketId,
			@ApiParam(value = "Ticket object that needs to be added to the kanban", required = true) @Valid @RequestBody Ticket body) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
