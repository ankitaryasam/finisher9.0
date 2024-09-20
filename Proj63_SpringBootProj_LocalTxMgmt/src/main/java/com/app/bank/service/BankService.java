package com.app.bank.service;

public interface BankService {
	
	public boolean transferMoney(long srcAccount, long destAccount, float amount) throws Exception;

}
