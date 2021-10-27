package com.jgcolab.mymenu.nubank;

public interface Processor {
	TransactionResult authorize(Transaction transaction, Account account);
}
