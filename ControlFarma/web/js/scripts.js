	function alerta(string){
		alert(string);
	}

	function addClass(classe, elemento) {
		document.getElementById(elemento).classList.add(classe);
	}

	function remClass(classe, elemento) {
		document.getElementById(elemento).classList.remove(classe);
	}

	function show1div(nome){
		var div = document.getElementsByTagName("div");
		for(var i = 0; i < div.length; i++){
			if(div[i].id == "maintxt" || div[i].id == "sidebar"){
				continue;
			}
			addClass('hidden',div[i].id);
		}
		remClass('hidden',nome);
	}

	function loadModule(modulo, lugar){
		$(lugar).load(modulo);
	}
	
	function confirmaProduto(id){
		var tabela = document.getElementById(id);
		var mensagem = "";
		var itens = ["Nome", "Código", "Princípio Ativo", "Categoria", "Lote", "Vencimento", "Valor Unitario"];
		for (let i = 0; i < tabela.rows.length-1; i++) {
			const linha = tabela.rows[i];
			mensagem += itens[i]+": "+linha.cells[1].getElementsByTagName('input')[0].value+"\n";
		}
		if(confirm(mensagem)){
			document.getElementsByTagName("form")[0].submit();
		}
	}
