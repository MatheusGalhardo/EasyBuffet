package mvc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.out;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/dashboard/new-event.html")
public class NovoEventoControler extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean persistido = false;
		Evento evento = new Evento();
		
		if(request.getParameter("nome") != null){
			evento.setNomeEvento(request.getParameter("nome"));
			evento.setDataEvento(Utilitarios.stringToCalendar(request.getParameter("data"), "dd/MM/yyyy"));
			String dataConvertida  = Utilitarios.converteDataCalendar(evento.getDataEvento(), true);
			evento.setNumeroConvidados(request.getParameter("convidados"));
			evento.setWebsiteEvento(request.getParameter("website"));
			evento.setDescricaoEvento(request.getParameter("descricao"));
			evento.setLocalEvento(request.getParameter("local"));
			evento.setEnderecoEvento(request.getParameter("endereco"));
			evento.setComplementoEndereco(request.getParameter("complemento"));
		
			boolean estaPreenchido = Utilitarios.verificaCampos(evento);
		
			if(estaPreenchido){
				try{
					EventoDao.inclui(evento);
					request.setAttribute("msgGeral", "Salvo com sucesso!");	
			
				}catch(Exception e){
					request.setAttribute("msgGeral", "Falha ao gravar evento.");
				}
			}
		}      
		
		request.getRequestDispatcher("new-event.jsp").
			forward(request, response);
                
		
	
	}
}
