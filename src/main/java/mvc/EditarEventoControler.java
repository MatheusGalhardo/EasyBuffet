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

@WebServlet(value = "/dashboard/edit-event.html")
public class EditarEventoControler extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Evento evento = new Evento();
		
		Long idEvento = Long.parseLong(request.getParameter("id"));
		
		String operacao = request.getParameter("operacao");
		
		if(idEvento != null && operacao != null && operacao.equals("editar")){
    		ArrayList<Evento> eventosE = new ArrayList();
            
            eventosE = (ArrayList<Evento>) EventoDao.listar();
            
            for(Evento p : eventosE){
            	if(p.getId().equals(idEvento)){
            		p.setDataString(Utilitarios.converteDataCalendar(p.getDataEvento(), true));
            		request.setAttribute("id", idEvento);
            		request.setAttribute("nomeEvento", p.getNomeEvento());
            		request.setAttribute("dataString", p.getDataString());
            		request.setAttribute("numeroConvidados", p.getNumeroConvidados());
            		request.setAttribute("websiteEvento", p.getWebsiteEvento());
            		request.setAttribute("descricaoEvento", p.getDescricaoEvento());
            		request.setAttribute("localEvento", p.getLocalEvento());
            		request.setAttribute("enderecoEvento", p.getEnderecoEvento());
            		request.setAttribute("complementoEvento", p.getComplementoEndereco());
            		
            		request.getRequestDispatcher("edit-event.jsp").
                    forward(request, response);
            		return;
            	}
            }	
		}
		
		if(request.getParameter("nome") != null){
			evento.setId(Long.parseLong(request.getParameter("id")));
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
					EventoDao.alterar(evento);
					request.setAttribute("msgGeral", "Salvo com sucesso!");	
			
				}catch(Exception e){
					request.setAttribute("msgGeral", "Falha ao gravar evento.");
				}
			}
		}      
		
		request.getRequestDispatcher("edit-event.jsp").
			forward(request, response);
                
		
	
	}
}
