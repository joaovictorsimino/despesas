package br.despesas.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.despesas.dao.TipoDao;
import br.despesas.domain.Tipo;

public class TipoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Tipo tipo = new Tipo();
		tipo.setNome("Outros");
		
		TipoDao tipodao = new TipoDao();
		tipodao.salvar(tipo);
	}
	@SuppressWarnings("unused")
	@Test
	@Ignore
	public void listar() {
		TipoDao tipoDao = new TipoDao();
		List<Tipo> resultado =  tipoDao.listar();
		
		for (Tipo tipo : resultado) {
			System.out.println(tipo.getNome());
			//System.out.println("Número de registros : " + resultado.size());
		}
	}
	@SuppressWarnings("unused")
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 10L;
		TipoDao tipoDao = new TipoDao();
		Tipo tipo = tipoDao.buscar(codigo);
		if (tipo == null) {
			System.out.println("Esse valor não existe no banco de dados");
		}else {
		System.out.println(tipo.getNome());
		}
	}
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		
		TipoDao tipoDao = new TipoDao();
		Tipo tipo = tipoDao.buscar(codigo);
		if (tipo == null) {
			System.out.println("Esse valor não existe no banco de dados");
		}else {
		//System.out.println(estado.getNome());
		tipoDao.excluir(tipo);
		}
		
	}
	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		
		TipoDao tipoDao = new TipoDao();
		Tipo tipo = tipoDao.buscar(codigo);
		
		tipo.setNome("Outros");
		tipoDao.editar(tipo);
	}
	
}
