package com.ru8anraj.kanban.model;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketTest {

	@Autowired
	Ticket ticket = new Ticket();

	@Test
	public void testToString() {
		ticket.toString();
	}

}
