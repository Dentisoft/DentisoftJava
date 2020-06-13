$(document).ready(function(){
    cargar();
          
     });
     

function cargar(){
    $.ajax({
        url:"ServletConsultardiagno",
        success:function(result){
            $('#res').html(result);
        }
    });
};


