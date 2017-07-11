package mvc;

import static java.lang.System.out;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utilitarios {

	
  //A funcao verifica campos realiza o trabalho de verificar se os campos minimos aceitaveis estao preenchidos para persistirem.
  public static boolean verificaCampos(Evento evento){
	  
	  if(evento.getNomeEvento() != null && evento.getNumeroConvidados() != null && 
	     evento.getEnderecoEvento() != null && evento.getDataEvento() != null){
		  return true;
	  }else{
			  return false;
		  }
	  }
  
  //Esta funcao e responsavel por receber um dado do tipo Calendar e retornar um string
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
  
  //Funcao responsavel por receber um string e retornar um calendar ja com a formatacao escolhida pelo metodo que realizou a chamada
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