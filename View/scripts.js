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