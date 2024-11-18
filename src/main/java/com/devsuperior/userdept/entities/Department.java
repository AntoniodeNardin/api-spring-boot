package com.devsuperior.userdept.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true) // Garantir que o nome seja único
	private String name;
	
	public Department() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
