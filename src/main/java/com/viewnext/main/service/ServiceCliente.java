package com.viewnext.main.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.viewnext.main.data.Clientes;
import com.viewnext.main.interfaces.ServiceClienteInterface;
import com.viewnext.main.repository.ClienteRepository;

@Service
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

		return clienteRepository.findClientesByNombre(nombre);
	}

	@Override
	public Clientes insertarCliente(Clientes cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public int borradoClienteByName(String nombre) {
		int nBorrado = clienteRepository.deleteClienteByName(nombre);
		if (nBorrado <= 0) {
			throw new EntityNotFoundException("No se ha borrado ninguna entidad");
		} else {
			return nBorrado;
		}

	}

}
