package br.org.universa.aplicacoesWeb.dominio.repositorios;

import java.util.List;

import br.org.universa.aplicacoesWeb.dominio.Cliente;
import br.org.universa.aplicacoesWeb.infra.dao.ClienteDAO;
import br.org.universa.aplicacoesWeb.infra.dao.GenericDAOImpl;

public class ClienteRepositorioImpl implements ClienteRepositorio {

	private GenericDAOImpl<Cliente, Long> cDAO;

	public ClienteRepositorioImpl() {
		this.cDAO = new ClienteDAO();
	}

	@Override
	public Cliente buscarPorId(Long id) {

		cDAO.iniciarTransacao();

		Cliente cliente = cDAO.buscarPorId(id, true);

		cDAO.encerrarTransacao();

		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		cDAO.iniciarTransacao();

		List<Cliente> clientes = cDAO.buscarTodos();
		cDAO.encerrarTransacao();

		return clientes;
	}

	@Override
	public Cliente salvarOuAtualizar(Cliente cliente) {
		cDAO.iniciarTransacao();
		if (cliente.getId() != null) {
			cliente = cDAO.atualizar(cliente);
		} else {
			cliente = cDAO.salvar(cliente);
		}
		cDAO.encerrarTransacao();
		return cliente;
	}

	@Override
	public void excluir(Cliente entidade) {

		cDAO.iniciarTransacao();

		cDAO.excluir(entidade.getId());

		cDAO.encerrarTransacao();

	}

}
