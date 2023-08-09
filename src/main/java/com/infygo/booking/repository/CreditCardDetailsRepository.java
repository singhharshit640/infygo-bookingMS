package com.infygo.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infygo.booking.entity.CreditCardDetailsEntity;

@Repository
public interface CreditCardDetailsRepository extends JpaRepository<CreditCardDetailsEntity, String>{

}
