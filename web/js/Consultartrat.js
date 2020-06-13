$(document).ready(function(){
    alert("entro");
    cargar();
         
     $('#InsertarTrat').submit(function (e){
          var docp=$('#codd').val();
         var du=$('#du').val();
         var des=$('#des').val();
         var nom=$('#nom').val();
         
         e.preventDefault();
    
         $.ajax({
             url:"ServletInsertartrat",
             data:{
            
                 docp:docp,
                 du:du,
                 des:des,
                 nom:nom
                               
             },
             success:function (result){
                 cargar();
             }
         });
     });
     });
     

function cargar(){
    $.ajax({
        url:"ServletConsultaTrat",
        success:function(result){
            $('#res').html(result);
        }
    });
};
