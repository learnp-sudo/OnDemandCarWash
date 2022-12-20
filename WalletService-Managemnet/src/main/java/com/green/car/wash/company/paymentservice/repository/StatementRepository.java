package com.green.car.wash.company.paymentservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.green.car.wash.company.paymentservice.model.Statement;
@Repository
public interface StatementRepository extends MongoRepository<Statement,Integer>{
  
	public List<Statement> findByStatementId(int statementId);
}
