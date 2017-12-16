<?php
	include("Cliente.php");

	class ClienteDAO{
		
		public function salvar($cliente){
			$arquivo = '../Model/clientes.txt';
			file_put_contents($arquivo, $cliente->toJson()."\n", FILE_APPEND);
		}
	}
?>
