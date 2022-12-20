package com.green.car.wash.company.paymentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.green.car.wash.company.paymentservice.model.Payment;
@Repository
public interface PaymentRepository extends MongoRepository<Payment,Integer>{

	 public Payment findByProfileId(int profileId);
}
