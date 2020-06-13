$(document).ready(function(){
    cargar();
          $('#InsertarFac').submit(function (e){
          var docp=$('#Docp').val();
         var fec=$('#fec').val();
         var val=$('#val').val();
         var des=$('#des').val();
         
         e.preventDefault();
    
         $.ajax({
             url:"ServletInsertarfac",
             data:{
            
                 docp:docp,
                 fec:fec,
                 val:val,
                 des:des
                               
             },
             success:function (result){
                 cargar();
             }
         });
     });
     });
     

function cargar(){
    $.ajax({
        url:"ServletConsultaFacturas",
        success:function(result){
            $('#res').html(result);
        }
    });
};
