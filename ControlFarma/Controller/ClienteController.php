	<?php

		include('../Model/ClienteDAO.php');

		class ClienteController{
			private $cliente;

			function __construct($nome, $cpf){
				$this->cliente = new Cliente($nome, $cpf);
			}

			public function salvar(){
				ClienteDAO::salvar($this->cliente);
			}

			public function getCliente(){
				return $this->cliente;
			}

			public function setCliente($cliente){
				$this->cliente = $cliente;
			}
		}

		$temp = new ClienteController($_POST["nome"], $_POST["cpf"]);

		$temp->salvar();
		echo '<meta http-equiv="refresh" content="0; url=../View/ClienteView.html">';
	?>
