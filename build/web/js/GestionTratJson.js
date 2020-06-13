$(document).ready(function(){
    alert ("en js");
$('.botonTrat').on('click', function(){
   insertar();
});
$('.actualizar').on('click', function(){
   actualizar();
});
$('.eliminar').on('click', function(){
   eliminar();
});

     
});
function insertar(){
    var dia=$('.cod').val();
    var dur=$('.du').val();
    var des=$('.des').val();
    var nom=$('.nom').val();
    
    alert (dia);
    
    $.ajax({
        type: 'POST',
        url: "ServletInserTratJson",
        dataType: 'json',
        data:{
            d:dia, du:dur, de:des, n:nom
        },
        
        
        success:function(res){
            if (res){
                alert ("datos guardados");
                cargarjson();
            }else{
                alert ("datos guardados");
                cargarjson();
            }
            console.log(res);
        }
    });
    
    
    

}

function actualizar(){
    
    var btn2=$('.actualizar').index(this);
    var cod=$('.codi').eq(btn2);
    var cod2=$('.codip').eq(btn2);
    var dur=$('.du').eq(btn2);
    var des=$('.des').eq(btn2);
    var nom=$('.nom').eq(btn2);
    
    var codi=cod.val();
    var codi2=cod2.val();
    var dura=dur.val();
    var desc=des.val();
    var nomb=nom.val();
    alert (codi);
    $.ajax({
        type: 'POST',
        url: "ServletActuTratJson",
        dataType: 'json',
        data:{
            c:codi, cc:codi2, du:dura, des:desc, n:nomb
        },
        
        
        success:function(res){
            if (res){
                alert ("datos guardados");
                cargarjson();
            }else{
                alert ("datos guardados");
                cargarjson();
            }
            console.log(res);
        }
    });
    
    
    

}


function eliminar(){
    
    var btn2=$('.actualizar').index(this);
    var cod=$('.codi').eq(btn2);
    
    
    var codi=cod.val();
    
    alert (codi);
    $.ajax({
        type: 'POST',
        url: "ServletElimTratJson",
        dataType: 'json',
        data:{
            c:codi
        },
        
        
        success:function(res){
            if (res){
                alert ("datos guardados");
                cargarjson();
            }else{
                alert ("datos guardados");
                cargarjson();
            }
            console.log(res);
        }
    });
    
    
    

}

