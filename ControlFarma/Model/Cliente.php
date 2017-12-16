<?php
	class Cliente{
		public $nome;
		public $cpf;

		function __construct($nome, $cpf){
			$this->setNome($nome);
			$this->setCPF($cpf);
		}

		public function getNome(){
			return $this->nome;
		}

		public function setNome($nome){
			$this->nome = $nome;
		}

		public function getCPF(){
			return $this->cpf;
		}

		public function setCPF($cpf){
			$this->cpf = $cpf;
		}

		public function toJson(){
			return json_encode($this);
		}
	}
?>