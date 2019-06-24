package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> searchForAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
