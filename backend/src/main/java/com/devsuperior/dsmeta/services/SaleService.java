package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	//chamada da interface que comunica-se com o banco de dados.
	@Autowired
	private SaleRepository repository;
	
	//buscandos todos os dados no banco de dados 
	public List<Sale> findSales() {
		return repository.findAll();		
	}

}
