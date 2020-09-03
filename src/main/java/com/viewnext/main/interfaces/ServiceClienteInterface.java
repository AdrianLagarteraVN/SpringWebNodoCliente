package com.viewnext.main.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viewnext.main.data.Clientes;

@Service
public interface ServiceClienteInterface {
	
	public List<Clientes> getAllClientes();

	public List<String> getAllNombres();
	
	public Clientes getClienteByName(String nombre);
	
	public Clientes insertarCliente(Clientes cliente);
	
	public void borradoClienteByName(String nombre);
}
