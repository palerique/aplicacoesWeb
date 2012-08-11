package br.org.universa.aplicacoesWeb.infra.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDAO<T, ID> {

	@PersistenceContext(unitName = "jpa-hibernate")
	protected EntityManager em;

	private Class<T> type;

	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa-hibernate");
		em = emf.createEntityManager();
	}

	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public T buscarPorId(ID id, boolean lock) {
		// TODO:trabalhar com o lock
		return (T) this.em.find(type, id);
	}

	@Override
	public List<T> buscarTodos() {
		final StringBuffer queryString = new StringBuffer("SELECT o from ");

		queryString.append(type.getSimpleName()).append(" o ");

		final Query query = this.em.createQuery(queryString.toString());

		return query.getResultList();

	}

	@Override
	public void excluir(ID id) {
		this.em.remove(this.em.getReference(type, id));
	}

	@Override
	public T salvar(T t) {
		this.em.persist(t);
		return t;
	}

	@Override
	public T atualizar(T entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public void iniciarTransacao() {
		em.getTransaction().begin();
	}

	public void encerrarTransacao() {
		em.getTransaction().commit();
	}

}
