package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.excessao.CodigoInexistenteException;
import br.com.fiap.excessao.CommitException;

public abstract class GenericDAOImpl<Tabela, Chave> implements GenericDAO<Tabela, Chave>{
	
	private EntityManager em;
	
	private Class<Tabela> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em= em;
		this.clazz =  (Class<Tabela>) ((ParametrizedType)getClass()
				.getGenericSuperclass().getActualTypeArguments()[0]);
	
	@Override
	public void cadastrar(Tabela entidade) {
		em.persist(entidade);
	}
	
	@Override
	public void atualizar(Tabela entidade) {
		em.merge(entidade);
	}
	
	@Override
	public void excluir(Chave id) throws CodigoInexistenteException {
		Tabela entidade = pesquisar(id);
		/*if (entidade == null) {
			throw new CodigoInexistenteException();
		}*/
		em.remove(entidade);
	}
	
	@Override
	public Tabela pesquisar(Chave id) throws CodigoInexistenteException {
		Tabela entidade = em.find(clazz, id);
		if (entidade == null) {
			throw new CodigoInexistenteException();
		}
		return null;
	}
	
	public void commit() throws CommitException {
		try {
		em.getTransaction().begin();
		em.getTransaction().commit();
		}
		catch(Exception e) {
		e.printStackTrace();
		em.getTransaction().rollback();
		}
	}
	
	
	
	
}
