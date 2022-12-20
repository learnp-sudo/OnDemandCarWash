package com.green.car.wash.company.paymentservice.model;

import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="statement")
public class Statement {
      @Id
	private int statementId;
	private TransactionType transactionType;
	private double amount;
	private LocalDateTime dateTime;
	private int orderId;
	private Payment ewallet;

	public Statement()
	{

	}
	public Statement(int statementId,TransactionType transactionType,double amount,LocalDateTime dateTime,Payment ewallet)
	{
		this.statementId=statementId;
		this.transactionType=transactionType;
		this.amount=amount;
		this.dateTime=dateTime;
		this.ewallet=ewallet;
	}
	public int getStatementId() {
		return statementId;
	}
	public void setStatementId(int statementId) {
		this.statementId = statementId;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Payment getEwallet() {
		return ewallet;
	}
	public void setEwallet(Payment ewallet) {
		this.ewallet = ewallet;
	}
}
