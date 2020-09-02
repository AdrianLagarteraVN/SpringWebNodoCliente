package com.viewnext.main.data;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Clientes")
public class Clientes {
	
	private String nombreCliente;
	private String telefonoCliente;
	private String fechaRegistroCliente;
	private String correoCliente;
}
