package com.clientes.APIClientes.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.clientes.APIClientes.entitys.Cliente;
import com.clientes.APIClientes.exception.ClientNotFoundException;
import com.clientes.APIClientes.repository.ClienteRepository;
@Service("ClienteService")
@Configurable
public class ClienteService {
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
	
	public Iterable<Cliente> listAllClients () {
		return clienteRepository.findAll();
	}
    
    public Cliente createNewClient(@Validated Cliente cliente){
    	
    	Cliente validatedBodyClient = clienteRepository.save(cliente);
    	
    	if(validatedBodyClient.equals(HttpStatus.BAD_REQUEST))
    		throw new ClientNotFoundException("O nome nao pode ser branco e o email deve ser verdadeiro");
    	
    	return validatedBodyClient;	
    }
    
    public Cliente getClient(int id) {

        Optional<Cliente> authenticateClient = clienteRepository.findById(id);

        if(!authenticateClient.isPresent())
            throw new ClientNotFoundException("Esse cliente nao existe, por favor tente novamente");

       return authenticateClient.get();
    }
    
    
    public Cliente updateClient(int id, Cliente cliente) {
    	Optional<Cliente> authenticateClient = clienteRepository.findById(id);
    	if(!authenticateClient.isPresent())
            throw new ClientNotFoundException("Esse cliente nao existe, por favor tente novamente "+HttpStatus.BAD_REQUEST);
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }
    
    public void deleteClient(int id) {
        clienteRepository.deleteById(id);
    }
}
