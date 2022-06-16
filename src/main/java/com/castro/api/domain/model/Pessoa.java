package com.castro.api.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa {

	private Long id;
	private String nome;
	private String email;
	private String telefone;

}