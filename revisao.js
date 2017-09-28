function exibeNome(){
		var elNome = document.getElementById('txtNome');
		var stgNome = elNome.value;
		var elDisplay = document.getElementById("display");
		elDisplay.innerText = stgNome;
}

function novoContato(){
		var elListaContatos = document.getElementById("listaContatos");
		var inputContato = document.createElement("input");
		inputContato.setAttribute("name","txtContato");

		//<label> Contato:</label>
		var labelContato = document.createElement("label");
		labelContato.innerText = "Contato:";
		//<br>
		var br = document.createElement("br");
		//<input type="button">
        var btnExcluir = document.createElement("input");
        btnExcluir.setAttribute("type", "button");
        btnExcluir.setAttribute("value", "-");
        btnExcluir.onclick = function (){
        	elListaContatos.removeChild(divLinha);        	
        };		
        //<div>
		var divLinha = document.createElement("div");
		divLinha.appendChild(labelContato);
		divLinha.appendChild(inputContato);
		divLinha.appendChild(btnExcluir);
		divLinha.appendChild(br);

		elListaContatos.appendChild(divLinha);
}

function imprimirDados(){
	var arrInputsContatos = document.frmContatos.txtContato;

	var saidaCont = document.getElementById("saidaContatos");
	var saida = "";
	for (i=0;i<arrInputsContatos.length;i++) {
			saida += arrInputsContatos[i].value + "<br>";
		}
		saidaCont.innerHTML = saida;
}