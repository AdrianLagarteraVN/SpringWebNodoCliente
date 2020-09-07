package com.viewnext.main.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.viewnext.main.data.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {

	@Query(value = "SELECT c from Clientes c where c.nombreCliente = :nombre")
	Clientes findClientesByNombre(String nombre);
	
	@Query(value =  "SELECT c.nombreCliente from Clientes c")
	List<String> findNombresClientes();
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Clientes c where c.nombreCliente = :nombre")
	int deleteClienteByName(String nombre);
}
