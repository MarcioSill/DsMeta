package com.devsuperior.dsmeta.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*/mapeamento objeto relacional entre as tabelas banco de dados e projeto
 * Entity faz o pre processamento e prepara o codigo para copilar
 * Table cria tabela no banco de dados 
 */
@Entity
@Table(name = "tb_sales")
public class Sale {
	
	/*/faz a pesquisa atraves do id 
	 * para auto incrementar usa-se GeneratedValue(strategy = GenerationType.IDENTITY
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String sellerName; // vendador
	private Integer visited; //numero de visitas
	private Integer deals;  // numero de vendas
	private Double amount;   // total contia vendida
	private LocalDate date;    // data da venda
	
	public Sale() {
	}

	public Sale(Long id, String sellerName, Integer visited, Integer deals, Double amount, LocalDate date) {
		super();
		this.id = id;
		this.sellerName = sellerName;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
