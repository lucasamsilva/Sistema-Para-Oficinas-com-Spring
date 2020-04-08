$(document).ready( function () {
    $('#myTable').DataTable({
    	"language":{
    	    "sEmptyTable": "Nenhum registro encontrado",
    	    "sInfo": "Mostrando _END_ de _TOTAL_ registros",
    	    "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
    	    "sInfoFiltered": "(Filtrados de _MAX_ registros)",
    	    "sInfoPostFix": "",
    	    "sInfoThousands": ".",
    	    "sLengthMenu": "_MENU_ resultados por página",
    	    "sLoadingRecords": "Carregando...",
    	    "sProcessing": "Processando...",
    	    "sZeroRecords": "Nenhum registro encontrado",
    	    "sSearch": "Pesquisar:",
    	    "oPaginate": {
    	        "sNext": "Próximo",
    	        "sPrevious": "Anterior",
    	        "sFirst": "Primeiro",
    	        "sLast": "Último"
    	    },
    	    "oAria": {
    	        "sSortAscending": ": Ordenar colunas de forma ascendente",
    	        "sSortDescending": ": Ordenar colunas de forma descendente"
    	    },
    	    "select": {
    	        "rows": {
    	            "_": "Selecionado %d linhas",
    	            "0": "Nenhuma linha selecionada",
    	            "1": "Selecionado 1 linha"
    	        }
    	    }
    	}
    });
	$('#myTable').addClass("table-responsive");
});