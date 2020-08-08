package com.venda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Produto produto;
	private Fornecedor fornecedor;
	private UnidadeProduto unidadeProduto;
	private Loja loja;
//	private String codigo_interno;
	private BigDecimal peso;
    private BigDecimal valor_custo ;
    private BigDecimal valor_venda ;
    private int    estoque_min;
    private int estoque_max;
    private int qtd_actual;
    private Date data_compra;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getValor_custo() {
		return valor_custo;
	}

	public void setValor_custo(BigDecimal valor_custo) {
		this.valor_custo = valor_custo;
	}

	public BigDecimal getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(BigDecimal valor_venda) {
		this.valor_venda = valor_venda;
	}

	public int getEstoque_min() {
		return estoque_min;
	}

	public void setEstoque_min(int estoque_min) {
		this.estoque_min = estoque_min;
	}

	public int getEstoque_max() {
		return estoque_max;
	}

	public void setEstoque_max(int estoque_max) {
		this.estoque_max = estoque_max;
	}

	public int getQtd_actual() {
		return qtd_actual;
	}

	public void setQtd_actual(int qtd_actual) {
		this.qtd_actual = qtd_actual;
	}
	
	
	public Date getData_compra() {
		return data_compra;
	}

	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_produto", nullable = false)
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_fornecedor", nullable = false)
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_unidadeProduto", nullable = false)
	public UnidadeProduto getUnidadeProduto() {
		return unidadeProduto;
	}

	public void setUnidadeProduto(UnidadeProduto unidadeProduto) {
		this.unidadeProduto = unidadeProduto;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_loja", nullable = false)
	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}