/**
 *
 */
package org.vwsp.managedBeans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.vwsp.entities.TipoPersonal;
import org.vwsp.entities.Empleado;
//import org.vwsp.entities.EncPregunta;
//import org.vwsp.entities.EncRespuesta;
//import org.vwsp.entities.EncTipoPregunta;
//import org.vwsp.service.TipoPersonalService;
import org.vwsp.service.EmpleadoService;
//import org.vwsp.service.IEncPreguntaService;
//import org.vwsp.service.IEncRespuestaService;
//import org.vwsp.service.IEncTipoPreguntaService;
/*
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;*/




/**
 * Descripci�n:
 * @version 1.0 21/04/2017
 * @author dzm7kex
 */
@ManagedBean
@ViewScoped
//@RequestScoped
//@SessionScoped

public class RespuestaMB implements Serializable {

//	private static final long serialVersionUID = 1L;
//
//	private List<TipoPersonal> encuestas;
//	private List<EncPregunta> preguntas;
//	private List<EncPregunta> listpreguntas;
//	private List<EncPregunta> idPreguntas;
//	private List<EncRespuesta> respuestas;
//	private List<EncRespuesta> comentarios;
//	private List<EncTipoPregunta> tipoPreguntas;
//	private List<EncRespuesta> contestacion;
//
//	private EncPregunta pregunta;
//	private EncRespuesta respuesta;
//	private Empleado encuestado;
//	private TipoPersonal encuesta;
//	private int res;
//	private int idEncuesta;
//	private int idEncuestado;
//	private int b;
//	private String respuestaAbierta;
//
//	public String getRespuestaAbierta() {
//		return respuestaAbierta;
//	}
//
//	public void setRespuestaAbierta(String respuestaAbierta) {
//		this.respuestaAbierta = respuestaAbierta;
//	}
//
//	private EncTipoPregunta tipoPreg;
//	int i;
//
//	Logger log;
//
//	@ManagedProperty(value = "#{encEncuestaService}")
//	private TipoPersonalService encEncuestaService;
//
//	@ManagedProperty(value = "#{encPreguntaService}")
//	private IEncPreguntaService encPreguntaService;
//
//	@ManagedProperty(value = "#{encTipoPreguntaService}")
//	private IEncTipoPreguntaService encTipoPreguntaService;
//
//	@ManagedProperty(value = "#{encRespuestaService}")
//	private IEncRespuestaService encRespuestaService;
//
//	@ManagedProperty(value = "#{encEncuestadoService}")
//	private EmpleadoService encEncuestadoService;
//
//	//@ManagedProperty(value = "#{restClient}")
//	//private RestClient restClient;
//
//	public RespuestaMB() {
//		super();
//	}
//
//	@PostConstruct
//	public void init() {
//		limpiarAtributos();
//
//		respuesta = new EncRespuesta();
//		obtenerId();
//		respuestas = new ArrayList<EncRespuesta>();
//	}
//	public void obtenerId(){
//		FacesContext context = FacesContext.getCurrentInstance();
//		int idEnc = new Integer((String)context.getExternalContext().getRequestParameterMap().get("idEncuesta"));
//		int idEncuestado = new Integer((String)context.getExternalContext().getRequestParameterMap().get("idEncuestado"));
//		cargarCatalogos(idEnc, idEncuestado);
//	}
//
//	private void cargarCatalogos(int idEnc,int idEncuestado) {
//
//        contestacion = encRespuestaService.getContestacion(idEnc, idEncuestado);
//        if(contestacion.size()>0){
//        	System.out.println(b+" Ya contestada");
//        	RequestContext context = RequestContext.getCurrentInstance();
//			   context.execute("PF('gracias').show();");
//        }else{
//        	 encuestado = encEncuestadoService.getEncuestado(idEncuestado).get(0);
//        	 preguntas = encPreguntaService.getPregunta(idEnc);
//             encuestas = encEncuestaService.getEncuestaById(idEnc);
//             encuesta = new TipoPersonal();
//             encuesta=encuestas.get(0);//traerlo en uno solo y no en una lista
//             pregunta=preguntas.get(0);
//        }
//
//		i=0;
//	}
//	public void insertEnc(){
//		String sMsg="";
//		try{
//			FacesContext contex = FacesContext.getCurrentInstance();
//	        contex.getExternalContext().redirect( "encuesta.xhtml?idEncuesta="+encuesta.getIdEncuesta()+"&idEncuestado="+encuestado.getIdEncuestado() );
//
//		}catch(Exception e){
//            e.printStackTrace();
//            sMsg = "Ingrese un CC";
//
//        }
//
//
//
//
//		/*ClientResponse response = restClient.getWebResource("encEncuestaRS/getEncuesta")
//				.type("application/json").get(ClientResponse.class);
//			if(response.getStatus() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//			}
//			encuestas = response.getEntity(new GenericType<List<EncEncuesta>>(){});
//
//			ClientResponse response2 = restClient.getWebResource("encTipoPreguntaRS/getTipoPregunta")
//					.type("application/json").get(ClientResponse.class);
//				if(response2.getStatus() != 200) {
//					throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
//				}
//				tipoPreguntas = response2.getEntity(new GenericType<List<EncTipoPregunta>>(){});*/
//		//	logger.info("Se termino la carga inicial...");
//
//		//WebResource webResource = client.resource("http://localhost:8080/Encuestador/rest/encEncuestaRS/getEncuesta");
//		//ClientResponse response = webResource.type("application/json").post(ClientResponse.class, encuestas);
//		//encuestas = response.getEntity(new GenericType<List<EncEncuesta>>(){});
//
//	}
//
//
//	private void limpiarAtributos() {
//
//		preguntas = new ArrayList<EncPregunta>();
//
//	}
//	
//	public void enviarMensaje(){
//		System.out.println("Hola mundo " + respuestaAbierta);
////        respuesta.setComentario(respuestaAbierta);
////        respuesta.setRespuesta(0);
//        sig();
//	}
//
//	  public void sig(){
//		  System.out.print("--entro-"+respuesta.getRespuesta()+"---"+pregunta.getTipoPregunta().getIdTipo());
//		  if(respuesta.getRespuesta()!=0&&pregunta.getTipoPregunta().getIdTipo()!=3||respuesta.getRespuesta()==0&&pregunta.getTipoPregunta().getIdTipo()==3){
//			  System.out.print("--si--preg"+preguntas.size()+"contados: "+i);
//			  i++;
//			  if(i<=preguntas.size()){
//		          respuesta.setEncEncuestado(encuestado);
//		          respuesta.setEncPregunta(pregunta);
//		          respuestas.add(respuesta);
//
//	          if(i<preguntas.size()){
//	        	  System.out.print("Crea- ");
//		          pregunta=preguntas.get(i);
//		          respuesta = new EncRespuesta();
//	          }else{
//	        	  pregunta.setPregunta("Gracias por su participación");
//				  pregunta.getTipoPregunta().setIdTipo(0);
//				  onInsert();
//	          }
//          }
//		}else{
//			System.out.println("NO ENTRO");
//		}
//
//
//	  }
//
//	  public void onInsert() {
//            try{
//            java.util.Date utilDate = new java.util.Date();
//    	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//    	    encuestado.setFechaContestacion(sqlDate);
//           	encEncuestadoService.saveOrUpdate(encuestado);
//     		encRespuestaService.saveOrUpdateAll(respuestas);
//
//     		 encuesta= new TipoPersonal();
//     		/*ClientResponse response = restClient.getWebResource("epUsuarioRS/getUsuarioByCurp")
//    				    				.type("application/json").get(ClientResponse.class);
//     		response = restClient.getWebResource("http://localhost:localhost:8080/Encuestador/encEncuestaRS/saveOrUpdate")
//     							 .type("application/json").post(ClientResponse.class, enc);*/
//            }catch(Exception e){
//                e.printStackTrace();
//
//
//            }
//
//    }
//	  public void c1(){
//		  respuesta.setRespuesta(1);
//		  int tipoPreguntaContestada = pregunta.getTipoPregunta().getIdTipo();
////		  respuesta.setComentario(); //Quiero empezar validación de pedir comentario si el usuario respondé NO a una pregunta SI/NO
////		  if(tipoPreguntaContestada==4)
////
////		  else sig();
//
//		  sig();
//	  }
//	  public void c2(){
//		  respuesta.setRespuesta(2);
//		  sig();
//	  }
//	  public void c3(){
//		  respuesta.setRespuesta(3);
//		  sig();
//	  }
//	  public void c4(){
//		  respuesta.setRespuesta(4);
//		  sig();
//	  }
//
//	//*******************************************  GET Y SET  ******************************************************************************
//
//	/**
//	 * @return the encuestas
//	 */
//	public List<TipoPersonal> getEncuestas() {
//		return encuestas;
//	}
//
//	/**
//	 * @param encuesta the encuestas to set
//	 */
//	public void setEncuestas(List<TipoPersonal> encuestas) {
//		this.encuestas = encuestas;
//	}
//
//	/**
//	 * @return the encEncuestaService
//	 */
//	public TipoPersonalService getEncEncuestaService() {
//		return encEncuestaService;
//	}
//
//	/**
//	 * @param encEncuestaService the encEncuestaService to set
//	 */
//	public void setEncEncuestaService(TipoPersonalService encEncuestaService) {
//		this.encEncuestaService = encEncuestaService;
//	}
//	/**
//	 * @return the encPreguntataService
//	 */
//	public IEncPreguntaService getEncPreguntaService() {
//		return encPreguntaService;
//	}
//
//	/**
//	 * @param encPreguntaService the encPreguntaService to set
//	 */
//	public void setEncPreguntaService(IEncPreguntaService encPreguntaService) {
//		this.encPreguntaService = encPreguntaService;
//	}
//
//	public IEncTipoPreguntaService getTipoEncPreguntaService() {
//		return encTipoPreguntaService;
//	}
//
//	/**
//	 * @param encTipoPreguntaService the encTipoPreguntaService to set
//	 */
//	public void setEncTipoPreguntaService(IEncTipoPreguntaService encTipoPreguntaService) {
//		this.encTipoPreguntaService = encTipoPreguntaService;
//	}
//	public IEncRespuestaService getEncRespuestaService() {
//		return encRespuestaService;
//	}
//
//	/**
//	 * @param encTipoPreguntaService the encTipoPreguntaService to set
//	 */
//	public void setEncRespuestaService(IEncRespuestaService encRespuestaService) {
//		this.encRespuestaService = encRespuestaService;
//	}
//
//	public EmpleadoService getEncEncuestdoService() {
//		return encEncuestadoService;
//	}
//
//	/**
//	 * @param encTipoPreguntaService the encTipoPreguntaService to set
//	 */
//	public void setEncEncuestadoService(EmpleadoService encEncuestadoService) {
//		this.encEncuestadoService = encEncuestadoService;
//	}
//	/**
//	 * @return the encuesta
//	 */
//	public TipoPersonal getEncuesta() {
//		return encuesta;
//	}
//
//	/**
//	 * @param encuesta the encuesta to set
//	 */
//	public void setEncuesta(TipoPersonal encuesta) {
//		this.encuesta = encuesta;
//	}
//
//	/**
//	 * @return the preguntas
//	 */
//	public List<EncPregunta> getPreguntas() {
//		return preguntas;
//	}
//
//	/**
//	 * @param preguntas the preguntas to set
//	 */
//	public void setPreguntas(List<EncPregunta> preguntas) {
//		this.preguntas = preguntas;
//	}
//
//	/**
//	 * @return the tipoPreguntas
//	 */
//	public List<EncTipoPregunta> getTipoPreguntas() {
//		return tipoPreguntas;
//	}
//
//	/**
//	 * @param tipoPreguntas the tipoPreguntas to set
//	 */
//	public void setTipoPreguntas(List<EncTipoPregunta> tipoPreguntas) {
//		this.tipoPreguntas = tipoPreguntas;
//	}
//
//	/**
//	 * @return the respuestas
//	 */
//	public List<EncRespuesta> getRespuestas() {
//		return respuestas;
//	}
//
//	/**
//	 * @param respuestas the respuestas to set
//	 */
//	public void setRespuestas(List<EncRespuesta> respuestas) {
//		this.respuestas = respuestas;
//	}
//
//	/**
//	 * @return the comentarios
//	 */
//	public List<EncRespuesta> getComentarios() {
//		return comentarios;
//	}
//
//	/**
//	 * @param comentarios the comentarios to set
//	 */
//	public void setComentarios(List<EncRespuesta> comentarios) {
//		this.comentarios = comentarios;
//	}
//
//	/**
//	 * @return the idPreguntas
//	 */
//	public List<EncPregunta> getIdPreguntas() {
//		return idPreguntas;
//	}
//
//	/**
//	 * @param idPreguntas the idPreguntas to set
//	 */
//	public void setIdPreguntas(List<EncPregunta> idPreguntas) {
//		this.idPreguntas = idPreguntas;
//	}
//
//	/**
//	 * @return the grafica
//	 */
//
//
//	/**
//	 * @return the pregunta
//	 */
//	public EncPregunta getPregunta() {
//		return pregunta;
//	}
//
//	/**
//	 * @param pregunta the pregunta to set
//	 */
//	public void setPregunta(EncPregunta pregunta) {
//		this.pregunta = pregunta;
//	}
//
//	/**
//	 * @return the tipoPregunta
//	 */
//	public EncTipoPregunta getTipoPregunta() {
//		return tipoPreg;
//	}
//
//	/**
//	 * @param tipoPregunta the tipoPregunta to set
//	 */
//	public void setTipoPregunta(EncTipoPregunta tipoPreg) {
//		this.tipoPreg = tipoPreg;
//	}
//
//	/**
//	 * @return the listpreguntas
//	 */
//	public List<EncPregunta> getListpreguntas() {
//		return listpreguntas;
//	}
//
//	/**
//	 * @param listpreguntas the listpreguntas to set
//	 */
//	public void setListpreguntas(List<EncPregunta> listpreguntas) {
//		this.listpreguntas = listpreguntas;
//	}
//
//	/**
//	 * @return the respuesta
//	 */
//	public EncRespuesta getRespuesta() {
//		return respuesta;
//	}
//
//	/**
//	 * @param respuesta the respuesta to set
//	 */
//	public void setRespuesta(EncRespuesta respuesta) {
//		this.respuesta = respuesta;
//	}
//
//	/**
//	 * @return the encuestado
//	 */
//	public Empleado getEncuestado() {
//		return encuestado;
//	}
//
//	/**
//	 * @param encuestado the encuestado to set
//	 */
//	public void setEncuestado(Empleado encuestado) {
//		this.encuestado = encuestado;
//	}
//
//	/**
//	 * @return the res
//	 */
//	public int getRes() {
//		return res;
//	}
//
//	/**
//	 * @param res the res to set
//	 */
//	public void setRes(int res) {
//		this.res = res;
//	}
//
//	/**
//	 * @return the idEncuesta
//	 */
//	public int getIdEncuesta() {
//		return idEncuesta;
//	}
//
//	/**
//	 * @param idEncuesta the idEncuesta to set
//	 */
//	public void setIdEncuesta(int idEncuesta) {
//		this.idEncuesta = idEncuesta;
//	}
//
//	/**
//	 * @return the idEncuestado
//	 */
//	public int getIdEncuestado() {
//		return idEncuestado;
//	}
//
//	/**
//	 * @param idEncuestado the idEncuestado to set
//	 */
//	public void setIdEncuestado(int idEncuestado) {
//		this.idEncuestado = idEncuestado;
//	}
//
//	/**
//	 * @return the contestacion
//	 */
//	public List<EncRespuesta> getContestacion() {
//		return contestacion;
//	}
//
//	/**
//	 * @param contestacion the contestacion to set
//	 */
//	public void setContestacion(List<EncRespuesta> contestacion) {
//		this.contestacion = contestacion;
//	}
//
//	/**
//	 * @return the b
//	 */
//	public int getB() {
//		return b;
//	}
//
//	/**
//	 * @param b the b to set
//	 */
//	public void setB(int b) {
//		this.b = b;
//	}


}
