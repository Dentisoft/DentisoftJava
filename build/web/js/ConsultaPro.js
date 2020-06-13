$(document).ready(function(){
alert("sda");
    cargar();
          $('#InsertarPro').submit(function (e){
 
          var docp=$('#codt').val();
         var des=$('#des').val();
         var val=$('#nom').val();
         var du=$('#du').val();
         
         e.preventDefault();
    
         $.ajax({
             url:"ServletInsertarpro",
             data:{
            
                 docp:docp,
                 des:des,
                 nom:val,
                 duu:du
                               
             },
             success:function (result){
                 cargar();
             }
         });
     });

     });
     

function cargar(){
    $.ajax({
        url:"ServletConsultarpro",
        success:function(result){
            $('#res').html(result);
        }
    });
};



