package br.org.universa.aplicacoesWeb.infra.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author PH
 * 
 * @param <T>
 * @param <ID>
 */
public interface GenericDAO<T, ID extends Serializable> {

	T buscarPorId(ID id, boolean lock);

	List<T> buscarTodos();

	T salvar(T entidade);

	T atualizar(T entidade);

	void excluir(ID id);

}