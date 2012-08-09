package br.org.universa.aplicacoesWeb.servico;

import java.util.List;

import javax.ejb.Local;

import br.org.universa.aplicacoesWeb.dominio.Cliente;

@Local
public interface ClienteNegocio {
	Cliente buscarPorId(Long id);

	List<Cliente> buscarTodos();

	Cliente salvarOuAtualizar(Cliente cliente);

	void excluir(Cliente entidade);
}
