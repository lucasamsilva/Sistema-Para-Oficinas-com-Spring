
    $.ajax({
        type: "get",
        url: "http://fipeapi.appspot.com/api/1/carros/marcas.json",
        success: function (data) {
            let elemento = document.getElementById("mont");
            for (let i = 0; i < data.length; i++) {
                elemento.innerHTML = elemento.innerHTML +
                    '<option idveiculo = "' + data[i]['id'] + '"' +  'value="' + data[i]['name'] + '">' + data[i]['name'] + '</option>';
            }
        }
    });
   
    $('#mod').change(function (){
		$("#inputmod").val(montadora = $('#mod option:selected').text());
    })
    
    $('#mont').change(function () {
    	montadora = $('#mont option:selected').text();
    	console.log(montadora);
		$("#inputmont").val(montadora);
        $('#mod').empty();
        let idselect = $("#mont option:selected").attr('idveiculo');
        if (idselect !== undefined){
        $.ajax({
            type: "get",
            url: `http://fipeapi.appspot.com/api/1/carros/veiculos/${idselect}.json`,
            success: function (data) {
                let elemento = document.getElementById("mod");
                for (let i = 0; i < data.length; i++) {
                    elemento.innerHTML = elemento.innerHTML +
                        '<option value="' + data[i]['name'] + '">' + data[i]['name'] + '</option>';
                }
            }
        });
        }
    })

