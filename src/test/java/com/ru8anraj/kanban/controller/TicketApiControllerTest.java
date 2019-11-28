package com.ru8anraj.kanban.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ru8anraj.kanban.model.Ticket;
import com.ru8anraj.kanban.service.TicketService;

public class TicketApiControllerTest {

	@Mock
	TicketService ticketService;

	@InjectMocks
	TicketApiController ticketApiController = new TicketApiController();
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPostTicketToDB() throws Exception {
		ticketApiController.addTicket(new Ticket());
	}

}
