var BASE_URI="http://localhost:8080/dsaApp/"

$(document).ready(function(){

            $("#Confirmar").click(function(){
            var nombre = $(".username").val();
            var contraseña = $(".password").val();
            var usuario = {"nombre": nombre, "contraseña": contraseña};
            console.log(usuario);

$.ajax({
            url: BASE_URI.concat("usermanager/modJugador"),
            headers:{ 'content-type':'application/json',"x-kii-appid": "{APP_ID}","x-kii-appkey":"{APP_ID}"},
            type: 'PUT',
            data:JSON.stringify(usuario),
            dataType: 'json',
            success: function (data) {
                window.localStorage.setItem("username",username);
                var url = "http://localhost:8080/html/index2.html";
                window.open(url, "_self");
            },

            error: function (e) {
             // log error in browser
             console.log(e.message);
            }
        });
    });
});