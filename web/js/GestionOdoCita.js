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
                <th>Documento Paciente</th>
                <th>Documento Odontologo</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Estado</th>
                
                
                </tr>`;
                
                
                for(var dat of result){
                    contenido.innerHTML+=`
                    <tr>
                        <td><input type='text' value="${dat.cod}"></td>
                    <td><input type='text' value="${dat.dpa}"></td>
                    <td><input type='text' value="${dat.dod}"></td>
                    <td><input type='text' value="${dat.fec}"></td>
                    <td><input type='text' value="${dat.hor}"></td>
                    <td><input type='text' value="${dat.est}"></td>
                    <form action="ServletPac" method="POST">
                    <input type="hidden" name="cod" value="${dat.cod}">
                    <td><input type="submit" name="borrarCit" value="Cancelar"></td>
                
            </form>
                    <form action="ServletOdo" method="POST">
                <input type="hidden" name="dpa" value="${dat.dpa}">
                <td><input type="submit" name="historial" value="ver historial"></td>
                
            </form>
                    </tr>
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


