package com.ru8anraj.kanban.repository;

import org.springframework.data.repository.CrudRepository;

import com.ru8anraj.kanban.entity.TicketEntity;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {

}
