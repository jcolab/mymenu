package com.jgcolab.mymenu.nubank;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TransactionResult {

	private Account account;
	private List<String> violacoes;
}
