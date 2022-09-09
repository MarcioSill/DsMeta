package com.devsuperior.dsmeta.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;

/*/
 * controle para acessar o backend
 * value = sales é o caminho que vou acessar  
 */

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SmsService smsService;
	
	@Autowired
	private SaleService Service;
	
	/*disponibilizando o metodo para o frontend
	 * Da mesma maneira que SaleService precisou do SaleRepository
	 *  o SaleControler vai precisar do SaleService 
	 *  controler chama o service e o service chama o repository
	 *  para buscar por paginas usa-se Pageable
	 *  no argumento acrecentar data minima e maxima para realizar a pesquisa 
	 *  será recebido como texto pela web e depois converte para data
	 */	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value="maxDate", defaultValue = "")	String maxDate, 
			Pageable pageable){
		return Service.findSales(minDate, maxDate, pageable);
	}
	
	/*
	 * faz a requisição para envio SMS
	 */
	@GetMapping("{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}

}
