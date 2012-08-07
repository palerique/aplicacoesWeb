package br.org.universa.aplicacoesWeb.infra.dao;

import org.hibernate.Session;

public class HibernateDAOFactory extends DAOFactory {

	@SuppressWarnings("rawtypes")
	private GenericHibernateDao instanciarDAO(Class daoClass) {

		try {
			GenericHibernateDao dao = (GenericHibernateDao) daoClass
					.newInstance();
			dao.setSession(getSessaoCorrente());
			return dao;
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível instanciar a DAO: "
					+ daoClass, e);
		}
	}

	private Session getSessaoCorrente() {

		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	@Override
	public ClienteDAO getClienteDAO() {

		return (ClienteDAO) instanciarDAO(ClienteDAOHibernate.class);
	}

}
