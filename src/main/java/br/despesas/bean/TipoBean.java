package br.despesas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.despesas.dao.TipoDao;
import br.despesas.domain.Gastos;
import br.despesas.domain.Tipo;




@SuppressWarnings({ "serial", "unused" })
@ManagedBean
@ViewScoped
public class TipoBean implements Serializable {
	private List<Tipo> tipos;
	private Tipo tipo;
	private Gastos gasto;
	
	public List<Tipo> getTipos() {
		return tipos;
	}


	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
    

	public Gastos getGasto() {
		return gasto;
	}


	public void setGasto(Gastos gasto) {
		this.gasto = gasto;
	}


	@PostConstruct
	public void listar() {
		
		try {
			gasto = new Gastos();
			TipoDao tipodao = new TipoDao();
			tipos = tipodao.listar();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void novo() {
		try {
			tipo = new Tipo();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void salvar() {
		try {
			
			TipoDao tipoDao = new TipoDao();
			tipoDao.merge(tipo);
			novo();
			
			tipos = tipoDao.listar();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void excluir(ActionEvent evento) {
		try {
			tipo = (Tipo) evento.getComponent().getAttributes().get("tipoSelecionado");
			TipoDao tipoDao = new TipoDao();
			tipoDao.excluir(tipo);
			novo();
			tipos = tipoDao.listar();
			
			
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
