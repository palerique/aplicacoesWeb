package br.org.universa.aplicacoesWeb.servico;

import java.util.List;

import javax.inject.Inject;

import br.org.universa.aplicacoesWeb.dominio.Cliente;
import br.org.universa.aplicacoesWeb.dominio.repositorios.ClienteRepositorio;

public class ClienteNegocioImpl implements ClienteNegocio {

	@Inject
	ClienteRepositorio repo;

	@Override
	public Cliente buscarPorId(Long id) {
		return repo.buscarPorId(id);
	}

	@Override
	public List<Cliente> buscarTodos() {
		return repo.buscarTodos();
	}

	@Override
	public Cliente salvarOuAtualizar(Cliente cliente) {
		try {
			return repo.salvarOuAtualizar(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void excluir(Cliente entidade) {
		repo.excluir(entidade);

	}

}
