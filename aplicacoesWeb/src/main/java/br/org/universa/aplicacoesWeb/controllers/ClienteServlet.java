package br.org.universa.aplicacoesWeb.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.universa.aplicacoesWeb.dominio.Cliente;
import br.org.universa.aplicacoesWeb.servico.ClienteNegocioImpl;

/**
 * 
 * Servlet que serve de controller para as interações da camada de apresentação
 * com o sistema.
 * 
 * Recebe as requisições do browser, processa e reencaminha as respostas para a
 * camada de apresentação.
 * 
 * @author bruno
 * @author ph
 */
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteNegocioImpl clienteService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			serve(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			serve(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Com o objetivo de reuso nos métodos doGet e doPost criamos esse método.
	 * 
	 * Ele que tem a inteligência para lidar com a requisição do cliente.
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	private void serve(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Capturo os parâmetros enviados pela camada de apresentação:
		String acao = request.getParameter("acao");
		String idString = request.getParameter("id");
		String cnpj = request.getParameter("cnpj");
		String endereco = request.getParameter("endereco");
		String bairro = request.getParameter("bairro");
		String municipio = request.getParameter("municipio");
		String estado = request.getParameter("estado");
		String telefone = request.getParameter("telefone");
		String contato = request.getParameter("contato");
		String homepage = request.getParameter("homepage");
		String quantidadeEmpregadosString = request
				.getParameter("quantidadeEmpregados");

		// O código abaixo escreve na resposta à partir do servlet, não é
		// recomendável mas é necessário conhecer!

		// PrintWriter out = response.getWriter();
		//
		// out.println("id =" + idString);
		// out.println("cnpj =" + cnpj);
		// out.println("endereço =" + endereco);
		// out.println("bairro =" + bairro);
		// out.println("municipio =" + municipio);
		// out.println("estado =" + estado);
		// out.println("telefone =" + telefone);
		// out.println("contato =" + contato);
		// out.println("homepage =" + homepage);
		// out.println("quantidade =" + quantidadeEmpregadosString);

		// À partir daqui vamos trabalhar de acordo com a ação desejada pelo
		// usuário!
		clienteService = new ClienteNegocioImpl();

		// Se o usuário quiser excluir o cliente então eu primeiro busco ele na
		// sessão e depois peço para excluí-lo!
		if (acao != null && acao.equals("remover")) {

			Cliente cliente = clienteService.buscarPorId(Long
					.parseLong(idString));

			clienteService.excluir(cliente);

			// Se o usuário quiser buscar um cliente para edição então eu acesso
			// o
			// banco, trago o cara e o disponibilizo para edição!
		} else if (acao != null && acao.equals("buscar")) {

			Cliente cliente = clienteService.buscarPorId(Long
					.parseLong(idString));

			request.setAttribute("cliente", cliente);

			// Caso não for exclusão nem busca então ou é salvar - sem id - ou
			// editar - com id -.
		} else {

			// Instancio o cliente de acordo com os dados capturados
			Cliente c = new Cliente();

			c.setCnpj(cnpj);
			c.setBairro(bairro);
			c.setContato(contato);
			c.setEndereco(endereco);
			c.setEstado(estado);
			c.setHomepage(homepage);
			c.setMunicipio(municipio);
			c.setTelefone(telefone);

			// Como os dados chegam sempre no formato textual - como String -
			// preciso converter aquilo que é numérico em tipo numérico!
			c.setQuantidadeEmpregados(Integer
					.parseInt(quantidadeEmpregadosString));

			if (idString != null && !idString.equals("")) {
				c.setId(Long.parseLong(idString));
			}

			clienteService.salvarOuAtualizar(c);

		}

		List<Cliente> clientes = clienteService.buscarTodos();

		request.setAttribute("clientes", clientes);

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

		rd.forward(request, response);

	}
}
