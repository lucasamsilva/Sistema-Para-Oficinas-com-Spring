$(".carros").addClass("active");

$(".excluir").click(function() {
	let id = $(this).attr("name");
	$("#modaltexto").html(`Deseja excluir o cadastro de ID = ${id}`);
	$("#botaoconfirmacao").attr("name", id);
});

window.onload = function check_placa() {
	console.log(window.location.href)
	const urlParams = new URLSearchParams(window.location.href);
	if(urlParams.has('http://localhost:8080/carros/lista?erro')){
		alert("Placa Dupĺicada")
	}
}

function check_form(){
	var inputs = document.getElementsByClassName('required');
  var len = inputs.length;
  var valid = true;
  for(var i=0; i < len; i++){
     if (!inputs[i].value){ valid = false; }
  }
  if (!valid){
  	alert('Por favor preencha todos os campos.');
    return false;
  } else { return true; }
}

$(".alterar").click(function() {
	let id = $(this).attr("name");
	let placa = $(this).attr("placa");
	let modelo = $(this).attr("modelo");
	let montadora = $(this).attr("montadora");
	$('#id').val(id);
	$('#placa').val(placa);
	$('#modelo').val(modelo);
	$('#montadora').val(montadora);
});

$(".cancelar").click(function() {
	$('#id').val('');
	$('#placa').val('');
	$('#modelo').val('');
	$('#montadora').val('');
});


$("#botaoconfirmacao").click(function() {
	let id = $("#botaoconfirmacao").attr("name");
	$.ajax({
		url : `/carros/delete/${id}`,
		type : 'delete',
		success : function() {
			location.reload();
		}
	})
});
