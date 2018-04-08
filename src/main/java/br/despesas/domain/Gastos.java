package br.despesas.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Gastos extends GenericDomain {
	//@SuppressWarnings("unused")
	@Column(length = 50, nullable = false)
	private String nome;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Tipo tipo;
	@Column(nullable=false, precision=7, scale=2)
	private BigDecimal valor;
	@Column(nullable=false)
	private Short parcelas;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;
	@Column(nullable=false)
	private Boolean debito;
	
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Short getParcelas() {
		return parcelas;
	}
	public void setParcelas(Short parcelas) {
		this.parcelas = parcelas;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public Boolean getDebito() {
		return debito;
	}
	public void setDebito(Boolean debito) {
		this.debito = debito;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
