$(document).ready(function(){
    alert("entro");
    cargar();
         
     $('#InsertarPac').submit(function (e){
         console.log("");
         var doc=$('#doc').val();
          var nom=$('#nom').val();
         var cla=$('#cla').val();
         var rol=$('#rol').val();
         var sex=$('#sex').val();
         var est=$('#est').val();
        var ema=$('#ema').val();
         var tel=$('#tel').val();
         var foto=$('#foto').val();
         e.preventDefault();
    
         $.ajax({
             url:"ServletInsertar",
             data:{
                 doc:doc,
                 nom:nom,
                 cla:cla,
                 rol:rol,
                 sex:sex,
                 est:est,
                 ema:ema,
                 tel:tel,
                 foto:foto                
             },
             success:function (result){
                 
                 cargar();
             }
         });
     });
     });
     

function cargar(){
    $.ajax({
        url:"ServletConsultaUsuarios",
        success:function(result){
            $('#res').html(result);
        }
    });
};
