package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	//chamada da interface que comunica-se com o banco de dados.
	@Autowired
	private SaleRepository repository;
	
	/*/buscandos todos os dados no banco de dados 
	public List<Sale> findSales() {
		return repository.findAll();		
	}
 	*/
	/*
	 * buscando por consulta acrecentendo no argumento String minDate, String maxDate e por pagina Pageable pageable
	 */
	public Page<Sale> findSales(String minDate, String maxDate ,Pageable pageable) {
		
		/*
		 * caso não tiver data pegará por padrão o especificdo pelo comando
		 * neste caso o intante e fuso horário do sistema Instant.now(), ZoneId.systemDefault()
		 */
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		/*
		 * convertendo a data recebida em testo para o formato data
		 * se minData for iqual vazio (nada solicitado) pega o today hora local.minusDay(tempo desejado),
		 *  senão a hora de solicitação pedida
		 */
		LocalDate min = minDate.equals("")? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("")? today : LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, pageable);		
	}
}
