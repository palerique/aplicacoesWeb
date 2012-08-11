package br.org.universa.aplicacoesWeb.dominio;

import junit.framework.Assert;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void metodosGetsESetsDevemFuncionar() {
		// Cenário:
		Cliente c = new Cliente();

		c.setBairro("Norte");
		c.setCnpj("99999999999/0001");
		c.setContato("PH");
		c.setEndereco("Rua da Alegria");
		c.setEstado("DF");
		c.setHomepage("www.google.com.br");
		c.setId(0l);
		c.setMunicipio("Águas Claras");
		c.setQuantidadeEmpregados(2000);
		c.setTelefone("33218181");

		// Ação:

		// Validações:

		Assert.assertEquals("Norte", c.getBairro());
		Assert.assertEquals("99999999999/0001", c.getCnpj());
		Assert.assertEquals("PH", c.getContato());
		Assert.assertEquals("Rua da Alegria", c.getEndereco());
		Assert.assertEquals("DF", c.getEstado());
		Assert.assertEquals("www.google.com.br", c.getHomepage());
		Assert.assertEquals(Long.valueOf(0), c.getId());
		Assert.assertEquals("Águas Claras", c.getMunicipio());
		Assert.assertEquals(2000, c.getQuantidadeEmpregados());
		Assert.assertEquals("33218181", c.getTelefone());

	}

}
