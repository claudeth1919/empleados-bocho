/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
		

     function cerrarModalNuevaEncuesta(){
//    	 var nombreProyecto = document.getElementById('tabs:nueva:txtNombre').value.replace(/\s/g, ''); 
//    	   if(nombreProyecto!=''){
//    		   PF('anexoPreguntasDialog').show();
//    	       PF('crearNuevaEncuestaDialog').hide();  
//    	   }
         
     } 
     
     function abrir(){
         PF('crearNuevaEncuestaDialog').show();
     } 
     function ocultar1(){
     	PF('cc').hide();  
        document.getElementById('monita').style.display="none";
        document.getElementById('monito').style.display="none";
        document.getElementById('btnInicio').style.display="none";
        document.getElementById('tituloEnc').style.display="none";
          
        document.getElementById('pregunta').style.display="inline";
        document.getElementById('opciones').style.display="block";
         
       }
           
           