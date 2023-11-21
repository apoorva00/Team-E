package com.project.Payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Payment.entity.Payment;

public interface PaymentRepo extends JpaRepository <Payment, Integer>{

}
