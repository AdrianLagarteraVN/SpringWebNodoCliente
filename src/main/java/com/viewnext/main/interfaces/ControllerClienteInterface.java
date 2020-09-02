package com.viewnext.main.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viewnext.main.data.Clientes;
import com.viewnext.main.utils.Constants;

@RequestMapping(value = Constants.CONST_BASE_PATH)
public interface ControllerClienteInterface {
	
	@GetMapping("/getAllClientes")
	public ResponseEntity<List<Clientes>> getClientes();
	
	@GetMapping("/getAllNombreClientes")
	public ResponseEntity<List<String>> getNombreClientes();

	@GetMapping("/getCliente")
	public ResponseEntity<String> getClienteByName(String name);
	
	
	@PostMapping("/insertarCliente")
	public ResponseEntity<String> postCliente(Clientes cliente);
	
	
	@DeleteMapping("/deleteClientesByName")
	public ResponseEntity<String> deleteClienteByName(String name);
	
	
}
