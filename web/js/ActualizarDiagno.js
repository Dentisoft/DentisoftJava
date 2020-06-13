$(document).ready(function(){

$(document).on('click','.actualizar',function(){
       

                 var bton=$('.actualizar').index(this);
         var doc=$('.codi').eq(bton).val();
         var docu=$('.codip').eq(bton).val();
          var fec=$('.fec').eq(bton).val();
         var des=$('.des').eq(bton).val();
  



            $.ajax({
             url:'ServletActualizarDiagno',
            
             data:{
                 dd:doc,

                 do:docu,
                 nn:fec,
                 rr:des
               
                        
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
          url:"ServletActualizarDiagno",
          data:{
            documento:documento

          },
          success:function(result){
              alert("sada"+doc);
              cargar();
          }
        });
});


});
function cargar(){
    $.ajax({
        url:"ServletConsultardiagno",
        success:function(result){

            $('#res').html(result);
        }
    });
};


