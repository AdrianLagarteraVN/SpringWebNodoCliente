package com.viewnext.main.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.main.data.Clientes;
import com.viewnext.main.interfaces.ControllerClienteInterface;
import com.viewnext.main.interfaces.ServiceClienteInterface;

@RestController
public class ControllerCliente implements ControllerClienteInterface {

	@Autowired
	ServiceClienteInterface servicio;

	@Override
	public ResponseEntity<List<Clientes>> getClientes() {
		List<Clientes> listaClientes = servicio.getAllClientes();
		ResponseEntity<List<Clientes>> response = new ResponseEntity<List<Clientes>>(listaClientes, HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<List<String>> getNombreClientes() {
		List<String> listaNombres = servicio.getAllNombres();
		ResponseEntity<List<String>> response = new ResponseEntity<List<String>>(listaNombres, HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<Clientes> getClienteByName(String name) {
		Clientes cliente = servicio.getClienteByName(name);
		ResponseEntity<Clientes> response = new ResponseEntity<Clientes>(cliente, HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<Clientes> postCliente(Clientes cliente) {
		Clientes clienteInsertado = servicio.insertarCliente(cliente);
		ResponseEntity<Clientes> response = new ResponseEntity<Clientes>(clienteInsertado, HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<String> deleteClienteByName(String name) {
		ResponseEntity<String> response;
		try {
			long nDelete = servicio.borradoClienteByName(name);
			response = new ResponseEntity<String>("Se han borrado, " + nDelete + " clientes por el nombre, " + name,
					HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			response = new ResponseEntity<String>("No se ha encontrado ninguna entidad", HttpStatus.NOT_FOUND);
			return response;
		}
		return response;
	}

}
