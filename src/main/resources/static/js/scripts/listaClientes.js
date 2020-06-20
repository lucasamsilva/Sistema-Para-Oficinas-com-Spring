function Pesquisar(){
		console.log("Pesquisei");
		var nome = document.getElementById("pesquisaNome").value;
		if (nome === "") {
			window.location.href = `/clientes`;
		} else {
			window.location.href = `/clientes?nome=${nome}`;
		}
}