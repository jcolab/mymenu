package com.jgcolab.mymenu.nubank;

public class ProcessorImpl implements Processor {
	@Override
	public TransactionResult authorize(Transaction transaction, Account account) {
		TransactionResult transactionResult = new TransactionResult();
		return transactionResult;
	}
}
