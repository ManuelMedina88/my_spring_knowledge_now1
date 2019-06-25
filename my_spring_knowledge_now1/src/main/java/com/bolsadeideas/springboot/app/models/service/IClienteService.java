package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.dao.entity.Cliente;

public interface IClienteService {

	public List<Cliente> searchForAll();
	
	public void save(Cliente cliente);
	
	public Cliente findById(Long id);
	
	public void deleteById(Long id);
}
