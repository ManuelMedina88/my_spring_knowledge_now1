package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> searchForAll() {
		
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		
		clienteDao.save(cliente);
				
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		
		return clienteDao.findById(id).orElse(null);
		
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		
		clienteDao.deleteById(id);
	}

}
