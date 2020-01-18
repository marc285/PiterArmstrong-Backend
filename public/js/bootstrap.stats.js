var BASE_URI="http://localhost:8080/dsaApp/"

function mystats(){
$.ajax({
            url: BASE_URI.concat("usermanager/getEstadisticas"),
            type: 'GET',
            dataType: 'json',
            success: function (data) {
               for (var i = 0; i < data.length; i++)
                {$("table").append("<tr><td>"+ data[i].vida+"</td><td>"+ data[i].defensa+"</td><td>"+ data[i].ataque+"</td><td>"+ data[i].dinero+"</td><td>"+ data[i].piezas+"</td><td>"+ data[i].pantalla+"</td></tr>");}
                };
                 error: function (e) {
                 // log error in browser
                console.log(e.message);
            }
        });
    }