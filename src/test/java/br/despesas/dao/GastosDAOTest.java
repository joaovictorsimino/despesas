package br.despesas.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.despesas.dao.GastosDao;
import br.despesas.domain.Gastos;
import br.despesas.domain.Tipo;


@SuppressWarnings("unused")
public class GastosDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Gastos gastos = new Gastos();
		gastos.setNome("Bom apetit");
		gastos.setDebito(true);
		gastos.setHorario(new Date());
		gastos.setParcelas(new Short("0"));
		gastos.setValor(new BigDecimal("30"));
		TipoDao tipoDAO = new TipoDao();
		Tipo tipo = tipoDAO.buscar(1L);
		gastos.setTipo(tipo);
		
		
		GastosDao gastosDao = new GastosDao();
		gastosDao.salvar(gastos);
	}
	@SuppressWarnings("unused")
	@Test
	@Ignore
	public void listar() {
		GastosDao gastosDao = new GastosDao();
		List<Gastos> resultado =  gastosDao.listar();
		
		for (Gastos gasto : resultado) {
			System.out.println(gasto.getNome());
			//System.out.println("Número de registros : " + resultado.size());
		}
	}
	@SuppressWarnings("unused")
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 10L;
		GastosDao gastosDao = new GastosDao();
		Gastos gastos = gastosDao.buscar(codigo);
		if (gastos == null) {
			System.out.println("Esse valor não existe no banco de dados");
		}else {
		System.out.println(gastos.getNome());
		}
	}
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		
		GastosDao gastosDao = new GastosDao();
		Gastos gastos = gastosDao.buscar(codigo);
		if (gastos == null) {
			System.out.println("Esse valor não existe no banco de dados");
		}else {
		//System.out.println(estado.getNome());
		gastosDao.excluir(gastos);
		}
		
	}
	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		
		GastosDao gastosDao = new GastosDao();
		Gastos gastos = gastosDao.buscar(codigo);
		
		gastos.setNome("Combustivel");
		gastosDao.editar(gastos);
	}
	
}
