package com.infygo.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infygo.booking.entity.PassengerDetailsEntity;

@Repository
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetailsEntity, Integer>{

}
