package com.green.car.wash.company.paymentservice.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.car.wash.company.paymentservice.model.Payment;
import com.green.car.wash.company.paymentservice.model.Statement;
import com.green.car.wash.company.paymentservice.model.TransactionType;
import com.green.car.wash.company.paymentservice.repository.PaymentRepository;
import com.green.car.wash.company.paymentservice.repository.StatementRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
     @Autowired
	PaymentRepository ewalletRepository;
	
     @Autowired
       StatementRepository statementRepository;
	@Override
	public List<Payment> getWallets() {
		
		return ewalletRepository.findAll();
	}

	@Override
	public Payment addWallet(Payment ewallet) {
		// TODO Auto-generated method stub
		return ewalletRepository.insert(ewallet);
	}

	@Override
	public void addMoney(int profileId, double money) {
		
		Payment ewallet=ewalletRepository.findByProfileId(profileId);
		double totalBalance=ewallet.getCurrentBalance()+money;
		  ewallet.setCurrentBalance(totalBalance);
		  ewalletRepository.save(ewallet);
		  Statement statement=new Statement(profileId,TransactionType.CREDIT,money,LocalDateTime.of(LocalDate.now(),LocalTime.now()),ewallet);
		  statementRepository.save(statement);
	}

	/*@Override
	public void updateWallet(Ewallet ewallet, double amount, String statement, int id) {
		
		
	}*/

	@Override
	public Payment getWalletById(int id) {
		
		return ewalletRepository.findByProfileId(id);
	}

	@Override
	public List<Statement> getStatementById(int statementId) {
		
		return statementRepository.findByStatementId(statementId);
	}

	@Override
	public List<Statement> getAllStatements() {
		
		return statementRepository.findAll();
	}

	@Override
	public void deleteWalletById(int id) {

   		  Payment ewallet=ewalletRepository.findByProfileId(id);
   		  ewallet.setCurrentBalance(0);
   		  ewalletRepository.save(ewallet);
   		  ewalletRepository.delete(ewallet);
	}

}
