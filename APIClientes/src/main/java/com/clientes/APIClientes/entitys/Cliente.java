package com.clientes.APIClientes.entitys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotBlank(message="O nome nao pode ser branco ou nulo")
	private String name;
	@NotBlank
    @Email(message = "Seu e-mail nao é valido, por favor digite um e-mail valido")
	private String email;
	public Cliente() {
		
	}
	public Cliente(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
