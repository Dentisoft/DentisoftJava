$(document).ready(function(){

$(document).on('click','.actualizar',function(){
   
                 var bton=$('.actualizar').index(this);
         var cod=$('.codi').eq(bton).val();
    var doc=$('.codip').eq(bton).val();
          var nom=$('.fec').eq(bton).val();
         var des=$('.des').eq(bton).val();
         var du=$('.dur').eq(bton).val();
  



            $.ajax({
             url:'ServletActualizarpro',
            
             data:{
                 ds:cod,

            dd:doc,
                 nn:nom,
                 cc:des,
                 rr:du
               
                        
             },
             
             success:function(result){
                     cargar();
             
             }
                    
         });

         
});
$(document).on('click','.eliminar',function(){
    var doc=$(this)[0];
    var documento=$(doc).attr('value');
    console.log(documento);
        $.ajax({
          url:"ServletActualizarpro",
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
        url:"ServletConsultarpro",
        success:function(result){
            $('#res').html(result);
        }
    });
};


