package com.viewnext.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.viewnext.main.data.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {

	
	Clientes findClientesByName(String nombre);
	
	@Query(value =  "SELECT c.nombreCliente from Clientes c")
	List<String> findNombresClientes();
	
	@Query(value = "DELETE FROM Clientes c where c.nombreCliente = :nombre")
	void deleteClienteByName(String nombre);
}
