package com.app.service;

import java.sql.SQLException;

import com.app.dao.BankDao;

public class BankServiceImpl implements BankService {
	
	private BankDao bankDao;
	
	public BankServiceImpl(BankDao bankDao) {
		this.bankDao=bankDao;
	}

	@Override
	public boolean transferMoney(long srcAccount, long destAccount, float amount) throws Exception {
		
		boolean flag = false;
		
		int count1 = bankDao.withdrawMoney(srcAccount, amount);
		int count2 = bankDao.depositeMoney(destAccount, amount);
		
		
		if(count1==0 || count2==0) {
			throw new SQLException("Internal problem in money transferring. Your request cannot be processed at this time");
		}
		else {
			flag = true;
		}
		
		return flag;
	}

}
