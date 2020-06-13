$(document).ready(function(){


$(document).on('click','.actualizar',function(){
   
                 var bton=$('.actualizar').index(this);
         var cod=$('.codi').eq(bton).val();
    var doc=$('.codip').eq(bton).val();
          var du=$('.du').eq(bton).val();
         var des=$('.des').eq(bton).val();
         var nom=$('.nom').eq(bton).val();
  



            $.ajax({
             url:'ServletActualizartrat',
            
             data:{
                 ds:cod,

            dd:doc,
                 nn:du,
                 cc:des,
                 rr:nom
               
                        
             },
             
             success:function(result){
                 $("#res").html(result);
                 cargar();
             }
                    
         });

         
});


$(document).on('click','.eliminar',function(){
    var doc=$(this)[0];
    var documento=$(doc).attr('value');
    console.log(documento);
        $.ajax({
          url:"ServletActualizartrat",
          data:{
            documento:documento

          },
          success:function(result){
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

     


