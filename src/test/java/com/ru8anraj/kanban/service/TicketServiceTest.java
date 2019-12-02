package com.ru8anraj.kanban.service;

import static com.ru8anraj.kanban.model.Ticket.StatusEnum.BACKLOG;
import static com.ru8anraj.kanban.model.Ticket.StatusEnum.COMPLETED;
import static com.ru8anraj.kanban.model.Ticket.StatusEnum.WORK_IN_PROGRESS;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ru8anraj.kanban.entity.TicketEntity;
import com.ru8anraj.kanban.model.Ticket;
import com.ru8anraj.kanban.model.Ticket.StatusEnum;
import com.ru8anraj.kanban.repository.TicketRepository;

public class TicketServiceTest {

	@Mock
	private TicketRepository ticketRepository;

	@InjectMocks
	private TicketService ticketService = new TicketService();

	private Ticket ticket;
	private TicketEntity ticketEntity;
	long ticketId;
	private ArrayList<StatusEnum> status = new ArrayList<StatusEnum>();

	@Before
	public void setUp() {
		initMocks(this);
		ticket = new Ticket();
		ticketEntity = new TicketEntity();
		ticketId = 1995L;
	}

	/*
	 * Positive scenario's
	 */

	@Test
	public void testAddTicket() {
		ticketService.addTicket(ticket);
	}

	@Test
	public void testFindAllTickets() throws Exception {
		ticketService.getAllTicket();
		verify(ticketRepository).findAll();
	}

	@Test
	public void testDeleteTicket() {
		ticketService.deleteTicket(ticketId);
		verify(ticketRepository).deleteById(ticketId);
	}

	@Test
	public void testGetAllTicketByStatus() {

		status.add(BACKLOG);
		ticketService.getAllTicketByStatus(status);
		verify(ticketRepository).findAllWithStatus(BACKLOG);

		status.add(WORK_IN_PROGRESS);
		ticketService.getAllTicketByStatus(status);
		verify(ticketRepository).findAllWithStatus(BACKLOG, WORK_IN_PROGRESS);

		status.add(COMPLETED);
		ticketService.getAllTicketByStatus(status);
		verify(ticketRepository).findAllWithStatus(BACKLOG, WORK_IN_PROGRESS, COMPLETED);
	}

	@Test
	public void testGetTicketById() throws Exception {
		ticketService.getAllTicketById(ticketId);
		verify(ticketRepository).findById(ticketId);
	}

	@Test
	public void testUpdateTicketById() throws Exception {
		ticketService.updateTicket(ticketId, ticket);
	}

	/*
	 * Error Scenarios
	 */
	@Test(expected = RuntimeException.class)
	public void testPostTicketToDBPassingNullthrowException() throws Exception {
		ticketService.addTicket(null);
	}

	@Test(expected = Exception.class)
	public void testExceptionHandlingAddTicket() throws Exception {
		when(ticketRepository.save(Mockito.any())).thenThrow(new Exception());
		ticketService.addTicket(ticket);
	}

//	@Test(expected = Exception.class)
//	public void testExceptionHandlingDeleteTicket() throws Exception {
//		when(ticketRepository.deleteById(ticketId)).thenThrow(new Exception());
//		ticketService.deleteTicket(ticketId);
//	}

	@Test(expected = Exception.class)
	public void testExceptionHandlingGetTickets() throws Exception {
		when(ticketRepository.findAll()).thenThrow(new Exception());
		ticketService.getAllTicket();
	}

	@Test(expected = Exception.class)
	public void testExceptionHandlingGetTicketById() throws Exception {
		when(ticketRepository.findById(ticketId)).thenThrow(new Exception());
		ticketService.getAllTicketById(ticketId);
	}

	@Test(expected = Exception.class)
	public void testExceptionHandlingGetTicketsByStatus() throws Exception {
		status.add(BACKLOG);
		when(ticketRepository.findAllWithStatus(BACKLOG)).thenThrow(new Exception());
		ticketService.getAllTicketByStatus(status);
	}

	@Test(expected = Exception.class)
	public void testExceptionHandlingUpdateTicketInFinding() throws Exception {
		when(ticketRepository.findById(ticketId)).thenThrow(new Exception());
		ticketService.updateTicket(ticketId, ticket);
	}

	@Test(expected = Exception.class)
	public void testExceptionHandlingUpdateTicketInSaving() throws Exception {
		when(ticketRepository.save(ticketEntity)).thenThrow(new Exception());
		ticketService.updateTicket(ticketId, ticket);
	}
}
