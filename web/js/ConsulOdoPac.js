$(document).ready(function(){
    alert ("en js");


$('.consul').on('click', function(){
   cargarjson();
});
     
});



function cargarjson(){
    
    alert ("entro consul json");
    $.ajax({
        url:"ServletConsulJson",
        dataType: 'json',
        success:function(result){
            console.log(result);
            
            
            var contenido=document.getElementById("contenedor");
            contenido.innerHTML='';
            var datos=result.length;
            if(datos>0){
                contenido.innerHTML=`
              
         
                <tr>
        
                <th>Documento</th>
                <th>Nombre</th>
                <th>Edad</th>
                
                
                
                </tr>`;
                
                
                for(var dat of result){
                    contenido.innerHTML+=`
                    <tr>
                     <td><input type='text' value="${dat.doc}"></td>
                    <td><input type='text' value="${dat.nom}"></td>
                    <td><input type='text' value="${dat.eda}"></td>
                    

                    </tr>
                    </table>
                `;
                }
            }
           
        }
    });
}/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




