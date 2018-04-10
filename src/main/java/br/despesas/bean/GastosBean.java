package br.despesas.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.despesas.dao.GastosDao;
import br.despesas.dao.TipoDao;
import br.despesas.domain.Gastos;
import br.despesas.domain.Tipo;

@SuppressWarnings({ "serial", "unused" })
@ManagedBean
@ViewScoped
public class GastosBean implements Serializable {
	private List<Gastos> gastos;
	private Gastos gasto;
	private Tipo tipo;
	private List<Tipo> tipos;
	private Date di;
	private Date df;
	
	
	public Date getDi() {
		return di;
	}

	public void setDi(Date di) {
		this.di = di;
	}

	public Date getDf() {
		return df;
	}

	public void setDf(Date df) {
		this.df = df;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}

	public List<Gastos> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gastos> gastos) {
		this.gastos = gastos;
	}

	public Gastos getGasto() {
		return gasto;
	}

	public void setGasto(Gastos gasto) {
		this.gasto = gasto;
	}

	@PostConstruct
	public void listar() {
		// tipos = new ArrayList<Tipo>();
		try {
			
			GastosDao gastosdao = new GastosDao();
			gastos = gastosdao.listar();
			novo();
			gasto.setParcelas(new Short("1"));
			gasto.setValor(new BigDecimal("0"));
			gasto.setHorario(new Date());
			
			di = new Date();
			df = new Date();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		try {
			gasto = new Gastos();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void salvar() {
		try {
			if (gasto.getParcelas() != 1) {
				for (int i = 0; i < gasto.getParcelas(); i++) {
					GastosDao gastosdao = new GastosDao();
					gastosdao.merge(gasto);
					Calendar cal = Calendar.getInstance();
					cal.setTime(gasto.getHorario());
					cal.add(Calendar.MONTH,1);
					gasto.setHorario(cal.getTime());
					
				}
				novo();
				gasto.setParcelas(new Short("1"));
				gasto.setValor(new BigDecimal("0"));
				gasto.setHorario(new Date());
				GastosDao gastosdao = new GastosDao();
				gastos = gastosdao.listar();
			} else {
				GastosDao gastosdao = new GastosDao();
				gastosdao.merge(gasto);

				novo();
				gasto.setParcelas(new Short("1"));
				gasto.setValor(new BigDecimal("0"));
				gasto.setHorario(new Date());
				gastos = gastosdao.listar();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			gasto = (Gastos) evento.getComponent().getAttributes().get("gastoSelecionado");
			GastosDao gastosdao = new GastosDao();
			gastosdao.excluir(gasto);
			novo();
			gastos = gastosdao.listar();

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}
	
	public void buscar() {
		// tipos = new ArrayList<Tipo>();
		try {

			GastosDao gastosdao = new GastosDao();
			gastos = gastosdao.listar();
			novo();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void filtrar() {
			
		
		try {
			
			GastosDao gastosdao = new GastosDao();
			gastos = gastosdao.filtro(di,df);
			novo();
			
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}
	
	

}
