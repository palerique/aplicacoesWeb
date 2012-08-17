<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

	</section> <section id="cadastro"> <!-- HTML5 section tag for the cadastro 'section' -->

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
			required tabindex="1" value="${cliente.cnpj}" />

		<!-- private String Contato; -->
		<p>
			<label for="contato">Contato</label>
		</p>
		<input type="text" id=contato name=contato placeholder="Contato"
			required tabindex="2" value="${cliente.contato}" />

		<!-- private String endereco; -->
		<p>
			<label for="endereco">Endereço</label>
		</p>
		<input type="text" id=endereco name=endereco placeholder="Endereço"
			required tabindex="3" value="${cliente.endereco}" />

		<!-- private String bairro; -->
		<p>
			<label for="bairro">Bairro</label>
		</p>
		<input type="text" id="bairro" name="bairro" placeholder="Bairro"
			required tabindex="4" value="${cliente.bairro}" />

		<!-- private String municipio; -->
		<p>
			<label for="municipio">Município</label>
		</p>
		<input type="text" id="municipio" name="municipio"
			placeholder="Município" required tabindex="5"
			value="${cliente.municipio}" />

		<!-- private String estado; -->
		<p>
			<label for="estado">Estado</label>
		</p>
		<input type="text" id="estado" name="estado" placeholder="Estado"
			required tabindex="6" value="${cliente.estado}" />

		<!-- private String telefone; -->
		<p>
			<label for="telefone">Telefone</label>
		</p>
		<input type="text" id="telefone" name="telefone"
			placeholder="Telefone" required tabindex="7"
			value="${cliente.telefone}" />

		<!-- private String homepage; -->
		<p>
			<label for="homepage">Homepage</label>
		</p>
		<input type="text" id="homepage" name="homepage"
			placeholder="www.paginadaempresa.com.br" required tabindex="8"
			value="${cliente.homepage}" />

		<!-- private int quantidadeEmpregados; -->
		<p>
			<label for="quantidadeEmpregados">Quantidade de Empregados</label>
		</p>
		<input type="text" id="quantidadeEmpregados"
			name="quantidadeEmpregados" placeholder="Quantidade de Empregados"
			required tabindex="2" value="${cliente.quantidadeEmpregados}" />

		<p>
			<input name="submit" type="submit" id="submit" tabindex="9"
				value="Enviar" />
		</p>

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
