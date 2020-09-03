package com.viewnext.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.viewnext.main.data.Clientes;
import com.viewnext.main.interfaces.ServiceClienteInterface;
import com.viewnext.main.repository.ClienteRepository;

public class ServiceCliente implements ServiceClienteInterface {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Clientes> getAllClientes() {
		return clienteRepository.findAll();

	}

	@Override
	public List<String> getAllNombres() {
		
		return clienteRepository.findNombresClientes();
	}

	@Override
	public Clientes getClienteByName(String nombre) {
		
		return clienteRepository.findClientesByName(nombre);
	}

	@Override
	public Clientes insertarCliente(Clientes cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void borradoClienteByName(String nombre) {
		clienteRepository.deleteClienteByName(nombre);

	}

}
