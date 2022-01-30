package com.jgcolab.mymenu.domain;

import lombok.*;
import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
public class Ingredients {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;

	public Ingredients(String description) {this.description = description;}
}
