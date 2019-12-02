package com.ru8anraj.kanban.entity;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketEntityTest {

	@Autowired
	TicketEntity ticketEntity = new TicketEntity();

	@Test
	public void testToString() {
		ticketEntity.toString();
	}

}
