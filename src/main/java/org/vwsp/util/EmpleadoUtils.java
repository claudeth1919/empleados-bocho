/**
 * 
 */
package org.vwsp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;


import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * 
 * Clase de utilerias para el foro
 * 
 * @author Ivan Alejandro
 *
 */
public class EmpleadoUtils {
	
	public final static int HTTP_CODE_200 = 200;
	
	public final static String DEFAULT_OPTION = "-";
	
	public final static String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static String CARACTERES_ACEPTADOS = "áéíóúÁÉÍÓÚABCDEFGHIJKLMÑNOPQRSTUVWXYZabcdefghijklmnñpqrstuvwxyz ";
	
	
	public final static Locale LOCALE_MX = new Locale("es_MX");
	
	public static FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	public static ExternalContext getExternalContext(){
		return getFacesContext().getExternalContext();
	}
	
	

	/**
	 * 
	 * Metodo que obtiene el anio actual
	 * 
	 * @return
	 */
	public static int getCurrentYear(){
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public static boolean isEmptyString(String cad){
		return cad == null || cad.isEmpty();
	}
	
	public static boolean isEmptyOrDefaultOption(String cad){
		return cad == null || cad.isEmpty() || cad.equals(DEFAULT_OPTION);
	}
	
	public static boolean isValidEmail(String cad){
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(cad);
		
		return matcher.matches();
	}
	
	public static String getNumberFormat(BigDecimal number){
		return getNumberFormat(number, "###,###.00");
	}
	
	public static String getNumberFormat(BigDecimal number, String pattern){
		Locale loc = new Locale("es", "MX");
		
		DecimalFormat dc = (DecimalFormat)NumberFormat.getInstance(loc);
		
		dc.applyPattern(pattern);
		
		return dc.format(number);
	}
	
	public static String getDateFormatted(Date fecha, String pattern, Locale locale){
		if(fecha != null){
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
			return sdf.format(fecha.getTime());
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * Metodo que obtiene una fecha con formato
	 * 
	 * @param fecha
	 * @param pattern
	 * @return
	 */
	public static String getDateFormatted(Date fecha, String pattern){
		if(fecha != null){
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(fecha.getTime());
		}else{
			return null;
		}
		
	}
	
	/**
	 * 
	 * Metodo que obtiene una fecha con el formato por default (dd/MM/yyyy)
	 * 
	 * @param fecha
	 * @return
	 */
	public static String getDateFormatted(Date fecha){
		return getDateFormatted(fecha, "dd/MM/yyyy");
		
	}
	
	
	
	/**
	 * 
	 * Muestra un dialogo
	 * 
	 * @param jsDialogName
	 */
	public static void showDialog(String jsDialogName){
		RequestContext.getCurrentInstance().execute("PF('" + jsDialogName + "').show()");
	}
	
	public static void updateViewElement(String element){
		RequestContext.getCurrentInstance().update(element);
	}
	
	/**
	 * 
	 * Oculta un dialogo
	 * 
	 * @param jsDialogName
	 */
	public static void hideDialog(String jsDialogName){
		RequestContext.getCurrentInstance().execute("PF('" + jsDialogName + "').hide()");
	}

	public static boolean isAlfabetico(String cadena) {
		for (Character letra : cadena.toCharArray()) {
			if(CARACTERES_ACEPTADOS.indexOf(letra+"")==-1) {
				return false;
			}
		}
		return true;
	}
	

}
