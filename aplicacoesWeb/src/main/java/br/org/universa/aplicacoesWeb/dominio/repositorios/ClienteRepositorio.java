package br.org.universa.aplicacoesWeb.dominio.repositorios;

import java.util.List;

import br.org.universa.aplicacoesWeb.dominio.Cliente;

public interface ClienteRepositorio {

	Cliente buscarPorId(Long id);

	List<Cliente> buscarTodos();

	Cliente salvarOuAtualizar(Cliente cliente);

	void excluir(Cliente entidade);

}
