package com.viewnext.main.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
		ResponseEntity<Clientes> response;
		try {
			Clientes clienteInsertado = servicio.insertarCliente(cliente);
			response = new ResponseEntity<Clientes>(clienteInsertado, HttpStatus.OK);

		} catch (EntityExistsException e) {
			throw new ResponseStatusException(HttpStatus.FOUND, e.getLocalizedMessage());

		}
		return response;
	}

	@Override
	public ResponseEntity<String> deleteClienteByName(String name) {
		ResponseEntity<String> response = null;
		try {
			int nDelete = servicio.borradoClienteByName(name);
			response = new ResponseEntity<String>("Se han borrado, " + nDelete + " clientes por el nombre, " + name,
					HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la entiada a eliminar");

		}
		return response;
	}

	@Override
	public ResponseEntity<Clientes> putCliente(Clientes cliente) {

		ResponseEntity<Clientes> response = null;
		try {
			Clientes clienteActualizado = servicio.updateCliente(cliente);
			response = new ResponseEntity<Clientes>(clienteActualizado, HttpStatus.OK);

		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		return response;
	}

}
