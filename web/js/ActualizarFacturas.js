$(document).ready(function(){

$(document).on('click','.actualizar',function(){
   
                 var bton=$('.actualizar').index(this);
         var ds=$('.codi').eq(bton).val();
    var docu=$('.codip').eq(bton).val();
          var fec=$('.fec').eq(bton).val();
         var val=$('.val').eq(bton).val();
         var des=$('.des').eq(bton).val();
  



            $.ajax({
             url:'ServletActualizarFac',
            
             data:{
                 ds:ds,

            dd:docu,
                 nn:fec,
                 cc:val,
                 rr:des
               
                        
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
          url:"ServletActualizarFac",
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
        url:"ServletConsultaFacturas",
        success:function(result){
            $('#res').html(result);
        }
    });
};


