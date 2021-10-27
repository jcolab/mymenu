package com.jgcolab.mymenu.domain;

import lombok.*;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor
public class Weekday {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String weekday;

	public Weekday(String weekday) {this.weekday = weekday;}
}
