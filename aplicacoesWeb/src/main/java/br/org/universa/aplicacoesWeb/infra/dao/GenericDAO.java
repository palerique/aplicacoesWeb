package br.org.universa.aplicacoesWeb.infra.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * @author PH
 * 
 * @param <T>
 * @param <ID>
 */
public interface GenericDAO<T, ID extends Serializable> {

	T buscarPorId(ID id, boolean lock);

	List<T> buscarTodos();

	List<T> buscarPorExemplo(T instanciaExemplo, String[] propriedadesExcluir);

	T salvarOuAtualizar(T entidade);

	void excluir(T entidade);

	List<T> buscarPorCriteria(Criterion... criteria);

}