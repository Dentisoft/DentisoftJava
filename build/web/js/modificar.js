$(document).ready(function (){
    
    
    
    $('.btnmod').on('click',function(){
        var btn=$('.btnmod').index(this);
        alert(btn);
        var cod=$('.cod').eq(btn);
        var cpr=$('.cpr').eq(btn);
        var fec=$('.fec').eq(btn);
        var val=$('.val').eq(btn);
        var des=$('.des').eq(btn);
        
        
        var c=cod.val();
        var p=cpr.val();
        var f=fec.val();
        var v=val.val();
        var d=des.val();
        
        alert(c+p+f+v+d);
        
        $.ajax({
            type:"POST",
            url:'ServletAux',
            data:{
                cc:c, 
                pp:p,
                ff:f,
                vv:v,
                dd:d
            },
            success: function (res) {
                console.log(res);
                
            }
            
            
        });
    });
});


