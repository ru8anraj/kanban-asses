package com.ru8anraj.kanban.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ru8anraj.kanban.entity.TicketEntity;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {

//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE TICKETS SET id = :ticketId, title = :body.title, status = :body.status, assignedTo = :body.assignedTo, createdOn = :body.createdOn WHERE id = :ticketId")
//	void updateTicketWithId(Long ticketId, TicketEntity body);
}
