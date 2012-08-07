package br.org.universa.aplicacoesWeb.infra.dao;

public abstract class DAOFactory {

	public static final Class HIBERNATE = br.org.universa.aplicacoesWeb.infra.dao.HibernateDAOFactory.class;

	public static DAOFactory instance(Class factory) {

		try {
			return (DAOFactory) factory.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível criar a DAOFactory - "
					+ factory);
		}

	}

	public abstract ClienteDAO getClienteDAO();

}
