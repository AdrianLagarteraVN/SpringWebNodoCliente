package com.viewnext.main.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.viewnext.main.data.Clientes;
import com.viewnext.main.utils.Constants;

@RequestMapping(value = Constants.CONST_BASE_PATH)
public interface ControllerClienteInterface {
	
	@GetMapping("/getAllClientes")
	public ResponseEntity<List<Clientes>> getClientes();
	
	@GetMapping("/getAllNombreClientes")
	public ResponseEntity<List<String>> getNombreClientes();

	@GetMapping("/getCliente")
	public ResponseEntity<Clientes> getClienteByName(String name);
	
	
	@PostMapping("/insertarCliente")
	public ResponseEntity<Clientes> postCliente(@RequestBody Clientes cliente);
	
	
	@PutMapping("/actualizarCliente")
	public ResponseEntity<Clientes> putCliente(@RequestBody Clientes cliente);
	
	@DeleteMapping("/deleteClienteByName")
	public ResponseEntity<String> deleteClienteByName(@RequestParam String name);
	
	
}
