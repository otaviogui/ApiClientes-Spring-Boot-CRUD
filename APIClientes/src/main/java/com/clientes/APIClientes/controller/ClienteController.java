package com.clientes.APIClientes.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.clientes.APIClientes.entitys.Cliente;
import com.clientes.APIClientes.services.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	 
	 private ClienteService clienteService;
	
	@GetMapping("/allClients")
	public Iterable<Cliente> listAllClients() {
		return clienteService.listAllClients();
    }
	
	@PostMapping("/newClient")
	
 	public Cliente createNewClient(@RequestBody @Valid Cliente cliente) {
		return clienteService.createNewClient(cliente);	
		
	}
	
	@GetMapping(value = "/client/{id}")
    public Cliente getClient(@PathVariable("id") int id) {
        return clienteService.getClient(id);
    }
	
	@PutMapping("/client/{id}")
	 public Cliente updateClient(@PathVariable("id") int id, @RequestBody Cliente cliente) {
        return clienteService.updateClient(id, cliente);
    }
	
	@DeleteMapping(value = "/client/{id}")
    public void deleteClient(@PathVariable("id") int id) {
        clienteService.deleteClient(id);
    }
}
