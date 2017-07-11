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

@WebServlet(value = "/dashboard/events.html")
public class GerenciaEventoControler extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	String operacao = request.getParameter("operacao");
    	
    	//Caso o conteudo da variavel operacao seja excluir e usado o id do evento para exclui-lo no banco.
    	if(operacao != null && operacao.equals("excluir")){
    		Long idEvento = Long.parseLong(request.getParameter("id"));
    		EventoDao.excluir(idEvento);
    	}
    	
    	//Neste ponto recebemos a lista de eventos para que a data seja convertida de date para string para que a tela receba.
        ArrayList<Evento> eventos = new ArrayList();
        
        eventos = (ArrayList<Evento>) EventoDao.listar();
        
        for(Evento p : eventos){
        	p.setDataString(Utilitarios.converteDataCalendar(p.getDataEvento(), true));
        }

        //Passando a lista para a tela e disparando a mesma.
        request.setAttribute("listaEventos", eventos);

        request.getRequestDispatcher("events.jsp").
            forward(request, response);

     }

}