package br.despesas.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.despesas.domain.Gastos;
import br.despesas.util.HibernateUtil;

public class GastosDao extends GenericDao<Gastos> {
	@SuppressWarnings("unchecked")
	public List<Gastos> filtro (Date di, Date df){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Gastos.class);
			consulta.add(Restrictions.between("horario",di,df));
			consulta.addOrder(Order.asc("nome"));
			List<Gastos> resultado = consulta.list();
			return resultado;
		}catch (RuntimeException e) {
			throw e;
		}finally {
			sessao.close();
		}
	}
}
