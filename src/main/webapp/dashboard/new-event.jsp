<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../css\estilo.css">
<link href="..\vendor\bootstrap\css\bootstrap.min.css" rel="stylesheet">

<title>EasyBuffet - Novo Eventos</title>
<link href="..\vendor\font-awesome\css\font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat|Oswald|Roboto"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">
<script src="js\jquery.js" type="text/javascript"></script>
<script src="js\jquery.maskedinput.js" type="text/javascript"></script>
</head>

<body>

	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navCollapse">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="index.html"><img
					src="..\img\logo.png" alt="EasyBuffet"></a>
			</div>
			<!-- Top Menu Items -->
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse"
				id="navCollapse" style="margin-right: 1%;">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="dashboard.html"><i
							class="fa fa-fw fa-dashboard"></i> Dashboard</a></li>
					<li><a href="#"><i class="fa fa-fw fa-table"></i> Meus
							Eventos</a></li>
					<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Sair</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Novo Evento</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-cutlery"></i> Aqui você
								poderá criar um novo evento.</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<h3 class="col-sm-12">Informações Gerais</h3>
						<form name="newEvent" role="form">
							<div class="form-group col-sm-12">
								<label>Nome do Evento</label> <input class="form-control"
									placeholder="Evento X" name="nome" required>
							</div>
							<div class="form-group col-sm-6">
								<label>Data do Evento</label> <input class="form-control" type="text" name="data" id="campoData" placeholder="dd/mm/yyyy" required>
								<script>
								jQuery(function($){
									   $("#campoData").mask("99/99/9999",{placeholder:"dd/mm/yyyy"});
									});
								</script>
							</div>
							<div class="form-group col-sm-6">
								<label>Numero de Convidados</label> <input class="form-control"
									placeholder="X" type="number" name="convidados" required>
							</div>
							<div class="form-group col-sm-6">
								<label>Tipo de Buffet</label> <select class="form-control"
									name="tipo">
									<option value="" selected disabled>Selecione um dos tipos</option>
									<option>Casamento</option>
									<option>Formatura</option>
									<option>Aniversario</option>
									<option>Confraternizacoes</option>
									<option>Debutante</option>
									<option>Bar Mitzvah</option>
								</select>
							</div>
							<div class="form-group col-sm-6">
								<label>Website</label> <input class="form-control"
									placeholder="www.eventox.com" name="website">
							</div>
							<div class="form-group col-sm-12">
								<label>Descrição do Evento</label>
								<textarea class="form-control" rows="3" name="descricao" placeholder="Alguns detalhes a serem ressaltados são: ..."></textarea>
							</div>
							<h3 class="col-sm-12">Local do Evento</h3>
							<div class="form-group col-sm-6">
								<label>Local do Evento</label> <select class="form-control"
									name="local" required>
									<option value="" selected disabled>Selecione um dos locais</option>
									<option>Oliveiras Place</option>
									<option>Casa Lis</option>
									<option>Espaco Goias</option>
									<option>Outro</option>
								</select>
							</div>
							<div class="form-group col-sm-6">
								<label>Endereço</label> <input class="form-control"
									placeholder="R do Espaco 1208, Jd Goias" name="endereco" required>
							</div>
							<div class="form-group col-sm-6">
								<label>Complemento</label> <input class="form-control"
									name="complemento">
							</div>
							<hr>
							<button type="submit" class="btn btn-success col-sm-12"
								data-toggle="modal" data-target="#confirmModal"
								style="margin-bottom: 50px;">Salvar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--End Modal -->
	<script src="js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<div class="alert alert-success" role="alert">${msgGeral}</div>
</body>

</html>






