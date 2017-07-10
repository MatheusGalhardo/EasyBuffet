package mvc;

import static java.lang.System.out;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utilitarios {

	
  public static boolean verificaCampos(Evento evento){
	  
	  if(evento.getNomeEvento() != null && evento.getNumeroConvidados() != null && 
	     evento.getEnderecoEvento() != null && evento.getDataEvento() != null){
		  return true;
	  }else{
			  return false;
		  }
	  }
  
  public static String converteDataCalendar(Calendar data, boolean formatar) {
      String saida = "";
      if (data != null) {
          if (formatar) {
              saida = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
          } else {
              saida = new SimpleDateFormat("yyyyMMdd").format(data.getTime());
          }
      }
      return saida;
  }
  
  public static Calendar stringToCalendar(String data, String formato) {
      try {
          SimpleDateFormat formatoDate = new SimpleDateFormat(formato);
          Calendar retorno = Calendar.getInstance();
          retorno.setTime(formatoDate.parse(data));
          return retorno;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }
  
  
  }