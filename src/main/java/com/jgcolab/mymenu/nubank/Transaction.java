package com.jgcolab.mymenu.nubank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class Transaction {
	String merchant;
	int amount;
	LocalDateTime time;
}

//- realizar saque
//  - o primeiro saque nao pode ultrapassar 90% do limite da conta
//- o usuario nao pode realizar dois saques em num intervalo menor que 1 minuto

//Retorno das operacoes
//- saldo indisponivel
//  msg: saldo indisponivel
//  code: 1000
//- limite de tempo excedido
//  msg: limite de tempo excedido
//  code: 1001
//- valor do saque ultrapassado
//  msg: valor do saque ultrapassado
//  code: 1002
//- conta inativada
//  msg: conta inativada
//  code: 1003
//todas as validacoes violadas devem ser retornadas
//https://refactoring.guru/pt-br/design-patterns/mediator
