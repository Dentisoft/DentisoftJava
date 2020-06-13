$(document).ready(function(){
    alert ("en js Pro");
$('.btnPro').on('click', function(){
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
    
    alert("entro insertar");
    var trat=$('.codtrat').val();
    var des=$('.descrip').val();
    var nom=$('.nombre').val();
    var dur=$('.dura').val();
    alert (trat);
    
    
    $.ajax({
        type: 'POST',
        url: "ServletInserProJson",
        dataType: 'json',
        data:{
            d:trat,de:des,  n:nom, du:dur
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
    var cod=$('.cod').eq(btn2);
    var cod2=$('.codtrat').eq(btn2);
    
    var des=$('.des').eq(btn2);
    var nom=$('.nom').eq(btn2);
    var dur=$('.dur').eq(btn2);
    
    var codi=cod.val();
    var codi2=cod2.val();
    
    var desc=des.val();
    var nomb=nom.val();
    var dura=dur.val();
    alert (codi);
    $.ajax({
        type: 'POST',
        url: "ServletActuProJson",
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
    
    var btn2=$('.eliminar').index(this);
    var cod=$('.cod').eq(btn2);
    
    
    var codi=cod.val();
    
    alert (codi);
    $.ajax({
        type: 'POST',
        url: "ServletElimProJson",
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

