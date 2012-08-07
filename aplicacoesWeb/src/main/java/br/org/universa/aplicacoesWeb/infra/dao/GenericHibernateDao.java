package br.org.universa.aplicacoesWeb.infra.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

public abstract class GenericHibernateDao<T, ID extends Serializable>
		implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	private Session session;

	public GenericHibernateDao() {

		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		System.out
				.println("***** INICIO GENERIC HIBERNATE DAO REFLECTION *****");
		System.out.println(getClass());
		System.out.println(getClass().getGenericSuperclass());
		System.out.println(((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);

		System.out.println("***** FIM GENERIC HIBERNATE DAO REFLECTION *****");
	}

	public void setSession(Session s) {

		this.session = s;
	}

	protected Session getSession() {

		if (session == null) {
			throw new IllegalArgumentException(
					"Sessão não foi setada na DAO antes do uso");
		}
		return session;
	}

	public Class<T> getPersistentClass() {

		return this.persistentClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T buscarPorId(ID id, boolean lock) {

		T entidade;
		if (lock) {
			entidade = (T) getSession().get(getPersistentClass(), id,
					LockOptions.UPGRADE);
		} else {
			entidade = (T) getSession().load(getPersistentClass(), id);
		}
		return entidade;
	}

	@Override
	public List<T> buscarTodos() {

		return buscarPorCriteria();
	}

	@Override
	public List<T> buscarPorExemplo(T instanciaExemplo,
			String[] propriedadesExcluir) {

		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example exemplo = Example.create(instanciaExemplo);
		for (String excluir : propriedadesExcluir) {
			exemplo.excludeProperty(excluir);
		}
		crit.add(exemplo);
		return crit.list();
	}

	@Override
	public T salvarOuAtualizar(T entidade) {

		getSession().saveOrUpdate(entidade);
		return entidade;
	}

	@Override
	public void excluir(T entidade) {

		getSession().delete(entidade);
	}

	@Override
	public List<T> buscarPorCriteria(Criterion... criterions) {

		Criteria crit = getSession().createCriteria(persistentClass);

		for (Criterion c : criterions) {
			crit.add(c);
		}

		return crit.list();

	}

	public void flush() {

		getSession().flush();
	}

	public void clear() {

		getSession().clear();
	}
}
