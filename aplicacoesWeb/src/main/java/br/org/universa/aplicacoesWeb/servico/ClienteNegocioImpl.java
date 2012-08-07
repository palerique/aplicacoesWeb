package br.org.universa.aplicacoesWeb.servico;

import java.util.List;

import br.org.universa.aplicacoesWeb.dominio.Cliente;
import br.org.universa.aplicacoesWeb.dominio.repositorios.ClienteRepositorio;

public class ClienteNegocioImpl implements ClienteNegocio {

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
		return repo.salvarOuAtualizar(cliente);
	}

	@Override
	public void excluir(Cliente entidade) {
		repo.excluir(entidade);

	}

}
