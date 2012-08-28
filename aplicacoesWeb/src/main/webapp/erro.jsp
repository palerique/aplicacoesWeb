<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ERRO!!! - Cadastro de Cliente</title>

<style type="text/css">
@import url("css/stylesheet.css");
</style>
<link href="css/blue.css" rel="stylesheet" type="text/css" />

<!-- Import google jquery -->
<script type="text/javascript" src="http://www.google.com/jsapi"></script>

<script type="text/javascript">
	google.load("jquery", "1.3.1");
	google.setOnLoadCallback(function() {

		//---------------- ColorChanger ----------------//

		// Change stylesheet to Blue	 
		$(".colorblue").click(function() {
			$("link").attr("href", "css/blue.css");
			return false;
		});

		// Change stylesheet to Red
		$(".colorred").click(function() {
			$("link").attr("href", "css/red.css");
			return false;
		});

		// Change stylesheet to Grey
		$(".colorgrey").click(function() {
			$("link").attr("href", "css/grey.css");
			return false;
		});

		// Change stylesheet to Brown
		$(".colorbrown").click(function() {
			$("link").attr("href", "css/brown.css");
			return false;
		});

		// Change stylesheet to Brown
		$(".colorgreen").click(function() {
			$("link").attr("href", "css/green.css");
			return false;
		});

		//---------------- Show and hide Colorchanger ----------------//

		$("#colors").hide();

		// Show colors when #showChanger clicked
		$("a#showChanger").click(function() {
			$("#colors").slideToggle("slow");
		});
	});
</script>

<!-- PNGFix for IE6 -->
<script type="text/javascript" src="js/jquery.pngFix.js"></script>

<!-- Active pngfix -->
<script type="text/javascript">
	$(document).ready(function() {
		$(document).pngFix();
	});
</script>

</head>
<body>

	<!-- Warp around everything -->
	<div id="warp">


		<!-- Header top -->
		<div id="header_top"></div>
		<!-- End header top -->


		<!-- Header -->
		<div id="header">
			<h2>Oops, alguma coisa deu errado!</h2>
		</div>
		<!-- End Header -->


		<!-- The content div -->
		<div id="content">

			<!-- text -->
			<div id="text">
				<!-- The info text -->
				<p>Desculpa, alguma coisa deu errado!!!</p>
				<br />
				<h3>Está perdido? Acesse...</h3>
				<!-- End info text -->

				<!-- Page links -->
				<ul>
					<li><a href="cliente">&raquo; Cadastro de Clientes</a></li>
				</ul>
				<!-- End page links -->
			</div>
			<!-- End info text -->


			<!-- Book icon -->
			<img id="book" src="images/img-01.png" alt="Book iCon" />
			<!-- End Book icon -->

			<div style="clear: both;"></div>
		</div>
		<!-- End Content -->


		<!-- Footer -->
		<div id="footer">

			<div style="clear: both;"></div>
		</div>
		<!-- End Footer -->


		<!-- Footer bottom -->
		<div id="footer_bottom"></div>
		<!-- End Footer bottom -->
		<div style="clear: both;"></div>


	</div>
	<!-- End Warp around everything -->

</body>
</html>