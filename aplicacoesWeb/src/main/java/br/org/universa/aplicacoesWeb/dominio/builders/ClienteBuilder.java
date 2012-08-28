package br.org.universa.aplicacoesWeb.dominio.builders;

import br.org.universa.aplicacoesWeb.dominio.Cliente;

public class ClienteBuilder {

	private String nome;
	private String cnpj;
	private String bairro;
	private String contato;
	private String endereco;
	private String estado;
	private String homepage;
	private String municipio;
	private String telefone;
	private Integer numeroEmpregados;
	private Long id;

	public ClienteBuilder criarClienteDeNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ClienteBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public ClienteBuilder noBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public ClienteBuilder comContato(String contato) {
		this.contato = contato;
		return this;
	}

	public ClienteBuilder noEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public ClienteBuilder noEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public ClienteBuilder comHomePage(String homepage) {
		this.homepage = homepage;
		return this;
	}

	public ClienteBuilder noMunicipio(String municipio) {
		this.municipio = municipio;
		return this;
	}

	public ClienteBuilder comTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public ClienteBuilder ondeTrabalhamEmpregados(int numeroEmpregados) {
		this.numeroEmpregados = numeroEmpregados;
		return this;
	}

	public ClienteBuilder comId(Long id) {
		this.id = id;
		return this;
	}

	public Cliente constroi() {
		Cliente cliente = new Cliente();

		cliente.setNome(nome);
		cliente.setCnpj(cnpj);
		cliente.setContato(contato);
		cliente.setEndereco(endereco);
		cliente.setEstado(estado);
		cliente.setHomepage(homepage);
		cliente.setId(id);
		cliente.setMunicipio(municipio);
		cliente.setNome(nome);
		cliente.setQuantidadeEmpregados(numeroEmpregados);
		cliente.setTelefone(telefone);
		cliente.setBairro(bairro);

		return cliente;
	}

}
