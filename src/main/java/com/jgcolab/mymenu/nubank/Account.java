package com.jgcolab.mymenu.nubank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter @Setter @AllArgsConstructor
public class Account {
		boolean active;
		int availableLimit;
		List<Transaction> history;

//	public Map<String,String> realizarSaque(int amount, Account acc) {
//		int primeiraTentativa = LocalDateTime.now().getMinute();
//		System.out.println(primeiraTentativa);
//		if (acc.isActive()) {
//			if (amount >= acc.availableLimit * 0.9) {
//				return Map.of("valor do saque ultrapassado", "1002");
//			}
//			if (amount <= 0) {
//				return Map.of("saldo indisponivel", "1000");
//			}
//			if (LocalDateTime.now().getMinute() > primeiraTentativa) {
//				acc.setAvailableLimit(amount);
//			} else {
//				return Map.of("limite de tempo excedido", "1001");
//			}
//		} else {
//			return Map.of("conta inativada", "1003");
//		}
//		return Map.of("1003", "Deu bom.");
//	}

	public Map<String, String> realizarSaque(Account account, Transaction transaction) {
		transaction.getTime().getMinute();
		if(this.isActive()) {
			if(transaction.getAmount() >= this.getAvailableLimit() * 0.9) {
				return Map.of("valor do saque ultrapassado", "1002");
			}
			if(transaction.getAmount() <= 0) {
				return Map.of("saldo indisponivel", "1000");
			}
			if (this.getHistory().size() == 0) {
				account.setAvailableLimit(account.getAvailableLimit() + transaction.getAmount());
			} else if (this.getHistory().size() > 0 && transaction.getTime().getMinute() < LocalDateTime.now().getMinute()){
				return Map.of("limite de tempo excedido", "1001");
			}
		} else {
			return Map.of("conta inativada", "1003");
		}
		account.getHistory().add(transaction);
		return Map.of("1003", "Deu bom.");
	}
}
