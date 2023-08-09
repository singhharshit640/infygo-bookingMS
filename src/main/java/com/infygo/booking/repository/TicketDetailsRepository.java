package com.infygo.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infygo.booking.entity.TicketDetailsEntity;

@Repository
public interface TicketDetailsRepository extends JpaRepository<TicketDetailsEntity, Integer>{

}
