package com.green.car.wash.company.paymentservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.green.car.wash.company.paymentservice.model.Payment;
import com.green.car.wash.company.paymentservice.model.Statement;
@Service
public interface PaymentService {

	public List<Payment> getWallets();
	public Payment addWallet(Payment ewallet);
	public void addMoney(int profileId,double money);
	//public void updateWallet(Ewallet ewallet,double amount,String statement,int id);
	public Payment getWalletById(int id);
	public List<Statement> getStatementById(int statementId);
	public List<Statement> getAllStatements();
	public void deleteWalletById(int id);
}
