package com.jgcolab.mymenu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Ingredients {
	@Id @Column (name = "ingredients_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name = "ingredients_name")
	private String name;
	@Column (name = "ingredients_description")
	private String description;
}
