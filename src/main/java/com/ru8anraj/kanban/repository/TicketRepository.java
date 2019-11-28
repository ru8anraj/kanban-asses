package com.ru8anraj.kanban.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ru8anraj.kanban.entity.TicketEntity;
import com.ru8anraj.kanban.model.Ticket.StatusEnum;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {

	@Query("select t from TicketEntity t where t.status = ?1")
	Iterable<TicketEntity> findAllWithStatus(StatusEnum statusEnum);

	@Query("select t from TicketEntity t where t.status = ?1 or t.status = ?2")
	Iterable<TicketEntity> findAllWithStatus(StatusEnum statusEnum, StatusEnum statusEnum2);
	
	@Query("select t from TicketEntity t where t.status = ?1 or t.status = ?2 or t.status = ?3")
	Iterable<TicketEntity> findAllWithStatus(StatusEnum statusEnum, StatusEnum statusEnum2, StatusEnum statusEnum3);

}
