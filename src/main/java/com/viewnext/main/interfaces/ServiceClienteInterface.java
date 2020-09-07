package com.viewnext.main.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viewnext.main.data.Clientes;

import javassist.NotFoundException;


public interface ServiceClienteInterface {
	
	public List<Clientes> getAllClientes();

	public List<String> getAllNombres();
	
	public Clientes getClienteByName(String nombre);
	
	public Clientes insertarCliente(Clientes cliente);
	
	public int borradoClienteByName(String nombre);
	
	public Clientes updateCliente(Clientes cliente);
}
