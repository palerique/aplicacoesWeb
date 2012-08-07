package br.org.universa.aplicacoesWeb.dominio;

public class Cliente {

	private int id;
	private String cnpj;
	private String endereco;
	private String bairro;
	private String municipio;
	private String estado;
	private String telefone;
	private String contato;
	private String homepage;
	private int quantidadeEmpregados;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public int getQuantidadeEmpregados() {
		return quantidadeEmpregados;
	}

	public void setQuantidadeEmpregados(int quantidadeEmpregados) {
		this.quantidadeEmpregados = quantidadeEmpregados;
	}

}
