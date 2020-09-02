package com.viewnext.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.viewnext.main.data.Clientes;
import com.viewnext.main.interfaces.ControllerClienteInterface;
import com.viewnext.main.interfaces.ServiceClienteInterface;

public class ControllerCliente implements ControllerClienteInterface{

	@Autowired
	ServiceClienteInterface servicio;
	
	
	@Override
	public ResponseEntity<List<Clientes>> getClientes() {
		
		return null;
	}

	@Override
	public ResponseEntity<List<String>> getNombreClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> getClienteByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> postCliente(Clientes cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> deleteClienteByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
