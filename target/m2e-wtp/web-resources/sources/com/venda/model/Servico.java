package com.venda.model;

import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "servico")
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private String codigo_interno;
	private BigDecimal valor_custo;
    private BigDecimal valor_venda ;
    private boolean activo_para_venda ;
    
    private String activo;
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo_interno() {
		return codigo_interno;
	}

	public void setCodigo_interno(String codigo_interno) {
		this.codigo_interno = codigo_interno;
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

	public boolean isActivo_para_venda() {
		
		return activo_para_venda;
	}
	
	

	public void setActivo_para_venda(boolean activo_para_venda) {
			
		this.activo_para_venda = activo_para_venda;
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
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	 @Transient
     public String getActivo() {
		     
    this.activo = isActivo_para_venda() ? "Sim" : "Não";
		
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}



	

}