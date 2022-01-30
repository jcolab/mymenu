package com.jgcolab.mymenu.domain;

import lombok.*;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor
public class Weekday {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String day;

	public Weekday(String day) {this.day = day;}
}
