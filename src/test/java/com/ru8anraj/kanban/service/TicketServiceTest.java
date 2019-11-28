package com.ru8anraj.kanban.service;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ru8anraj.kanban.repository.TicketRepository;

public class TicketServiceTest {

	@Mock
	private TicketRepository ticketRepository;

	@InjectMocks
	private TicketService ticketService = new TicketService();

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test(expected = RuntimeException.class)
	public void testPostTicketToDBPassingNullthrowException() throws Exception {
		ticketService.addTicket(null);
	}

	@Test
	public void testFindAllTickets() throws Exception {
		ticketService.getAllTicket();
	}

	@Test
	public void setUpForDelete() {
		long ticketId = 1995L;
		ticketService.deleteTicket(ticketId);
		Mockito.verify(ticketRepository).deleteById(ticketId);
	}

}
