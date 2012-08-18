<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">

<!-- This is a demonstration of HTML5 goodness with healthy does of CSS3 mixed in -->
<head>

<title>Cadastro de Clientes</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<!--[if IE]>
    	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!--[if IE 7]>
    	<link rel="stylesheet" href="css/ie7.css" type="text/css" media="screen" />
    <![endif]-->

<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.0/jquery.min.js"
	type="text/javascript"></script>
<script src="js/jquery.anchor.js" type="text/javascript"></script>
<script src="js/jquery.fancybox-1.2.6.pack.js" type="text/javascript"></script>

</head>

<body>

	<header> <!-- HTML5 header tag -->

	<div id="headercontainer">

		<h1>
			<a class="introlink anchorLink" href="#intro">Cadastro de
				Clientes</a>
		</h1>

		<nav> <!-- HTML5 navigation tag -->
		<ul>
			<li><a class="introlink anchorLink" href="#intro">Intro</a></li>
			<li><a class="listalink anchorLink" href="#lista">Lista de
					Clientes</a></li>
			<li><a class="cadastrolink anchorLink" href="#cadastro">Cadastro</a></li>
		</ul>
		</nav>

	</div>

	</header>

	<section id="contentcontainer"> <!-- HTML5 section tag for the content 'section' -->

	<section id="intro">

	<h2 class="intro">
		Trabalho da disciplina <strong><a target="_blank"
			class="featured"
			href="http://moodle.universa.org.br/course/view.php?id=213">Aplicações
				Web</a></strong>. <span class="sub">Desenvolvido pelos alunos <strong><a
				class="featured"
				href="mailto:brunobdantas@gmail.com?Subject=AplicaçõesWeb">Bruno</a></strong>
			e <strong><a target="_blank" class="featured"
				href="http://about.me/palerique">PH</a></strong> durante a pós graduação em <strong><a
				target="_blank" class="featured"
				href="http://www.universa.org.br/ueg_mbas_pos_view.asp?curso=235">Engenharia
					e Desenvolvimento de Software</a></strong> na <strong><a
				target="_blank" class="featured" href="http://www.universa.org.br/">Universa</a></strong>
			ministrada pelo professor e coordenador <strong><a
				class="featured"
				href="mailto:academico.email@gmail.com?Subject=AplicaçõesWeb">Michel
					Anderson</a></strong>.
		</span>
	</h2>

	</section> <!-- HTML5 section com a lista de clientes cadastrados --> <section
		id="lista">

	<h2 class="cadastro">Clientes Cadastrados</h2>


	<c:choose>
		<c:when test="${not empty clientes}">
			<p>Lista com todos os clientes cadastrados no sistema</p>

			<div>
				<table id="tabela-clientes">
					<tr>
						<th>Contato</th>
						<th>CNPJ</th>
						<th>Homepage</th>
						<th>Endereço</th>
						<th>Bairro</th>
						<th>Município</th>
						<th>Estado</th>
						<th>Telefone</th>
						<th>Quantidade de Empregados</th>
						<th>Editar</th>
						<th>Excluir</th>
					</tr>

					<c:forEach var="cli" items="${clientes}">
						<tr>
							<td><c:out value="${cli.contato}" /></td>
							<td><c:out value="${cli.cnpj}" /></td>
							<td><c:out value="${cli.homepage}" /></td>
							<td><c:out value="${cli.endereco}" /></td>
							<td><c:out value="${cli.bairro}" /></td>
							<td><c:out value="${cli.municipio}" /></td>
							<td><c:out value="${cli.estado}" /></td>
							<td><c:out value="${cli.telefone}" /></td>
							<td><c:out value="${cli.quantidadeEmpregados}" /></td>
							<td><c:url value="cliente" var="urlEditar">
									<c:param name="acao" value="buscar" />
									<c:param name="id" value="${cli.id}" />
								</c:url> <a href="${urlEditar}">Editar</a></td>
							<td><c:url value="cliente" var="urlRemover">
									<c:param name="acao" value="remover" />
									<c:param name="id" value="${cli.id}" />
								</c:url> <a href="${urlRemover}">Remover</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</c:when>
		<c:otherwise>
			<p>Nenhum Cliente Cadastrado no Sistema</p>
		</c:otherwise>

	</c:choose> </section> <!-- HTML5 section tag for the cadastro 'section' --> <section
		id="cadastro">

	<h2 class="cadastro">Cadastro de Clientes</h2>

	<p>Formulário para cadastro de pessoas jurídicas.</p>

	<form id="cadastroform" method="post" action="cliente">

		<!-- private Long id; -->
		<input type="hidden" name="id" value="${cliente.id}" />

		<!-- private String cnpj; -->
		<p>
			<label for="cnpj">CNPJ</label>
		</p>
		<input type="text" id="cnpj" name="cnpj" placeholder="99999999/0001"
			tabindex="1" value="${cliente.cnpj}" />

		<!-- private String Contato; -->
		<p>
			<label for="contato">Contato</label>
		</p>
		<input type="text" id=contato name=contato placeholder="Contato"
			tabindex="2" value="${cliente.contato}" />

		<!-- private String endereco; -->
		<p>
			<label for="endereco">Endereço</label>
		</p>
		<input type="text" id=endereco name=endereco placeholder="Endereço"
			tabindex="3" value="${cliente.endereco}" />

		<!-- private String bairro; -->
		<p>
			<label for="bairro">Bairro</label>
		</p>
		<input type="text" id="bairro" name="bairro" placeholder="Bairro"
			tabindex="4" value="${cliente.bairro}" />

		<!-- private String municipio; -->
		<p>
			<label for="municipio">Município</label>
		</p>
		<input type="text" id="municipio" name="municipio"
			placeholder="Município" tabindex="5" value="${cliente.municipio}" />

		<!-- private String estado; -->
		<p>
			<label for="estado">Estado</label>
		</p>
		<input type="text" id="estado" name="estado" placeholder="Estado"
			tabindex="6" value="${cliente.estado}" />

		<!-- private String telefone; -->
		<p>
			<label for="telefone">Telefone</label>
		</p>
		<input type="text" id="telefone" name="telefone"
			placeholder="Telefone" tabindex="7" value="${cliente.telefone}" />

		<!-- private String homepage; -->
		<p>
			<label for="homepage">Homepage</label>
		</p>
		<input type="text" id="homepage" name="homepage"
			placeholder="www.paginadaempresa.com.br" tabindex="8"
			value="${cliente.homepage}" />

		<!-- private int quantidadeEmpregados; -->
		<p>
			<label for="quantidadeEmpregados">Quantidade de Empregados</label>
		</p>
		<input type="text" id="quantidadeEmpregados"
			name="quantidadeEmpregados" placeholder="Quantidade de Empregados"
			tabindex="2" value="${cliente.quantidadeEmpregados}" />

		<p>
			<input name="submit" type="submit" id="submit" tabindex="9"
				value="Enviar" />
		</p>

		<!-- TODO: inserir o atributo required nos inputs types requeridos-->

	</form>


	</section> <footer> <!-- HTML5 footer tag -->

	<ul>
		<li><img src="images/twitter.png" alt="" /><a target="_blank"
			href="http://twitter.com/tkenny">Follow me on Twitter</a></li>
		<li><a target="_blank"
			href="http://inspectelement.com/articles/code-a-backwards-compatible-one-page-portfolio-with-html5-and-css3">Back
				to the Tutorial on Inspect Element</a></li>
	</ul>

	</footer> </section>

</body>

</html>
