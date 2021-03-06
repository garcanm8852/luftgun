<%@ page language='java' contentType='text/html; charset=UTF-8'
	pageEncoding='UTF-8'%>

<!DOCTYPE html>

<html lang='en'>

<head>
<meta charset='UTF-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css'
	integrity='sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l'
	crossorigin='anonymous'>
<script src='https://code.jquery.com/jquery-3.5.1.slim.min.js'
	integrity='sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj'
	crossorigin='anonymous'></script>
<script
	src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js'
	integrity='sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns'
	crossorigin='anonymous'></script>
	
<title>Catálogo</title>
</head>

<body>

	<header>
		<nav class='navbar navbar-expand-lg navbar-light bg-light fixed-top '>
			<a class='navbar-brand '>LuftGun</a>
			<button class='navbar-toggler ' data-target='#my-nav '
				data-toggle='collapse ' aria-controls='my-nav '
				aria-expanded='false ' aria-label='Toggle navigation '>
				<span class='navbar-toggler-icon '></span>
			</button>
			<div id='my-nav ' class='collapse navbar-collapse '>
				<ul class='navbar-nav mr-auto '>
					<li class='nav-item '><a class='nav-link ' href='Index '>Inicio</a>
					</li>
					<li class='nav-item active'><a class='nav-link ' href='Catalogo '
						tabindex='-1 ' aria-disabled='true '>Catalogo</a></li>
															<li class="nav-item "><a class="nav-link " href="Carrito "
						tabindex="-1 " aria-disabled="true ">Carrito</a></li>
				
				</ul>
			</div>
		</nav>
	</header>


	<section class='container'>
		<article class='row mt-5'>
			<div class='col-md-12 mt-5 text-center'>
				<h1>Compra realizada con éxito</h1>
				<h2 class="mt-3">El envío tardará entre 1 día y 15 años</h2>
				<p class="h6 mt-3">No nos hacemos remponsables de la duración del envío y del estado del paquete.</p>
			</div>
		</article>

		<article class='row justify-content-between mt-5'>
			<div class='col-md-12'>
				<div class="row">
				<a href="Catalogo" class="btn btn-primary h3 w-100">Volver a la tienda</a>
				</div>
			</div>
		</article>

	</section>



</body>

</html>