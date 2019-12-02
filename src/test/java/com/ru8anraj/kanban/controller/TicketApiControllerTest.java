package com.ru8anraj.kanban.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ru8anraj.kanban.model.Ticket;
import com.ru8anraj.kanban.model.Ticket.StatusEnum;
import com.ru8anraj.kanban.service.TicketService;

public class TicketApiControllerTest {

	@Mock
	TicketService ticketService;

	@InjectMocks
	TicketApiController ticketApiController = new TicketApiController();

	private Long ticketId;

	private Ticket ticket;

	private List<StatusEnum> status;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ticket = new Ticket();
		ticketId = 1995L;
		status = new ArrayList<StatusEnum>();
	}

	/*
	 * Positive Scenarios
	 * 
	 */

	@Test
	public void testPostTicketToDB() {
		ticketApiController.addTicket(new Ticket());
	}

	@Test
	public void testGetTicket() {
		ticketApiController.findAllTickets();
	}

	@Test
	public void testDeleteTicket() {
		ticketApiController.deleteTicket(ticketId);
	}

	@Test
	public void testGetTicketById() {
		ticketApiController.getTicketById(ticketId);
	}

	@Test
	public void testGetTicketByStatus() {
		List<StatusEnum> status = new ArrayList<StatusEnum>();
		ticketApiController.findTicketsByStatus(status);
	}

	@Test
	public void testUpdateTicket() {
		ticketApiController.updateTicket(ticketId, ticket);
	}

	/*
	 * Error Scenarios
	 */

	@Test(expected = Exception.class)
	public void testErrorHandlingAddTicket() {
		when(ticketService.addTicket(ticket)).thenThrow(new Exception());
		ticketApiController.addTicket(ticket);
	}

	@Test(expected = Exception.class)
	public void testErrorHandlingGetTicket() {
		when(ticketService.getAllTicket()).thenThrow(new Exception());
		ticketApiController.findAllTickets();
	}

	@Test(expected = Exception.class)
	public void testErrorHandlingGetTicketById() {
		when(ticketService.getAllTicketById(ticketId)).thenThrow(new Exception());
		ticketApiController.getTicketById(ticketId);
	}

	@Test(expected = Exception.class)
	public void testErrorHandlingGetTicketByStatus() {
		when(ticketService.getAllTicketByStatus(status)).thenThrow(new Exception());
		ticketApiController.findTicketsByStatus(status);
	}

	@Test(expected = Exception.class)
	public void testErrorHandlingDeleteTicket() {
		when(ticketService.deleteTicket(ticketId)).thenThrow(new Exception());
		ticketApiController.deleteTicket(ticketId);
	}
	
	@Test(expected = Exception.class)
	public void testErrorHandlingUpdateTicket() {
		when(ticketService.updateTicket(ticketId, ticket)).thenThrow(new Exception());
		ticketApiController.updateTicket(ticketId, ticket);
	}
}
