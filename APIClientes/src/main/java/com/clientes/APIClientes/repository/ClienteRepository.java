package com.clientes.APIClientes.repository;



import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clientes.APIClientes.entitys.Cliente;

@Repository
@Transactional
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{	
	
	@Override
    List<Cliente> findAll();
}
