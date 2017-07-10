package mvc;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.out;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/dashboard/new-event.html")
public class EventoControler extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean persistido = false;
		Evento evento = new Evento();		
		
		evento.setNomeEvento(request.getParameter("nome"));
		evento.setDataEvento(Utilitarios.stringToCalendar(request.getParameter("data"), "dd/mm/yyyy"));
		evento.setNumeroConvidados(request.getParameter("convidados"));
		evento.setWebsiteEvento(request.getParameter("website"));
		evento.setDescricaoEvento(request.getParameter("descricao"));
		evento.setLocalEvento(request.getParameter("local"));
		evento.setEnderecoEvento(request.getParameter("endereco"));
		evento.setComplementoEndereco(request.getParameter("complemento"));
		
		boolean estaPreenchido = Utilitarios.verificaCampos(evento);
		
		if(estaPreenchido){
			if(persistido){
				request.setAttribute("msgGeral", "Salvo com sucesso!");
				}else{
					request.setAttribute("msgGeral", "Falha ao salvar!");
				}
		}
               
		request.getRequestDispatcher("new-event.jsp").
			forward(request, response);
                
     }
	
}
