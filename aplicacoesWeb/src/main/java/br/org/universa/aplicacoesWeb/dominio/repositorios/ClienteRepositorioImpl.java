package br.org.universa.aplicacoesWeb.dominio.repositorios;

import java.util.List;

import br.org.universa.aplicacoesWeb.dominio.Cliente;
import br.org.universa.aplicacoesWeb.infra.dao.ClienteDAO;
import br.org.universa.aplicacoesWeb.infra.dao.HibernateDAOFactory;
import br.org.universa.aplicacoesWeb.infra.dao.HibernateUtil;

public class ClienteRepositorioImpl implements ClienteRepositorio {

	@Override
	public Cliente buscarPorId(Long id) {
		HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();

		ClienteDAO cDAO = new HibernateDAOFactory().getClienteDAO();

		Cliente cliente = cDAO.buscarPorId(id, true);

		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().commit();
		} catch (Exception e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
			e.printStackTrace();
		}

		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();

		ClienteDAO cDAO = new HibernateDAOFactory().getClienteDAO();

		List<Cliente> clientes = cDAO.buscarTodos();

		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().commit();
		} catch (Exception e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
			e.printStackTrace();
		}

		return clientes;
	}

	@Override
	public Cliente salvarOuAtualizar(Cliente cliente) {
		HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();

		ClienteDAO cDAO = new HibernateDAOFactory().getClienteDAO();

		cliente = cDAO.salvarOuAtualizar(cliente);

		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().commit();
		} catch (Exception e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
			e.printStackTrace();
		}

		return cliente;
	}

	@Override
	public void excluir(Cliente entidade) {
		HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();

		ClienteDAO cDAO = new HibernateDAOFactory().getClienteDAO();

		cDAO.excluir(entidade);

		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().commit();
		} catch (Exception e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
			e.printStackTrace();
		}

	}

}
