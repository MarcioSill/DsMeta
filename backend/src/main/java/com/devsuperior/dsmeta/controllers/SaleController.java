package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;

/*/
 * controle para acessar o backend
 * value = sales é o caminho que vou acessar  
 */

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService Service;
	
	/*disponibilizando o metodo para o frontend
	 * Da mesma maneira que SaleService precisou do SaleRepository
	 *  o SaleControler vai precisar do SaleService 
	 *  controler chama o service e o service chama o repository
	 */	
	@GetMapping
	public List<Sale> findSales(){
		return Service.findSales();
	}

}
