package br.org.universa.aplicacoesWeb.infra.dao;

import javax.persistence.EntityManager;

import br.org.universa.aplicacoesWeb.dominio.Cliente;

public class ClienteDAO extends GenericDAOImpl<Cliente, Long> implements
		GenericDAO<Cliente, Long> {

	public ClienteDAO(EntityManager em) {
		super(em);
	}

	public ClienteDAO() {
		super();
	}

}
