package br.org.universa.aplicacoesWeb.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.org.universa.aplicacoesWeb.dominio.Cliente;

public class ClienteNegocioImplTest {

	private ClienteNegocio cNeg;

	@Before
	public void setup() {
		this.cNeg = new ClienteNegocioImpl();
	}

	@Test
	public void testCRUDClienteNegocio() {
		// Listar:
		List<Cliente> clientes = cNeg.buscarTodos();

		int counter = clientes.size();

		Cliente c = new Cliente();

		c.setBairro("Norte");
		c.setCnpj("9999999999/0001");
		c.setContato("Bruno");
		c.setEndereco("Rua Buriti");
		c.setEstado("DF");
		c.setHomepage("www.google.com.br");
		c.setMunicipio("Águas Claras");
		c.setQuantidadeEmpregados(1000);
		c.setTelefone("33218181");

		// Salvar
		c = cNeg.salvarOuAtualizar(c);

		assertNotNull(c);

		Long id = c.getId();

		assertTrue(0 != c.getId());

		// Buscar por id:
		c = cNeg.buscarPorId(id);

		assertNotNull(c);

		clientes = cNeg.buscarTodos();

		assertEquals((counter + 1), clientes.size());

		// Editar:

		c.setContato("Dom Pedro II");

		cNeg.salvarOuAtualizar(c);

		c = cNeg.buscarPorId(id);

		assertEquals("Dom Pedro II", c.getContato());

		// Excluir:
		cNeg.excluir(c);

		clientes = cNeg.buscarTodos();

		assertEquals(counter, clientes.size());

		c = cNeg.buscarPorId(id);

		assertNull(c);
	}

}
