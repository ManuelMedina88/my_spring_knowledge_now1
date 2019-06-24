package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.dao.entity.Cliente;

public interface IClienteService {

	public List<Cliente> searchForAll();
}
