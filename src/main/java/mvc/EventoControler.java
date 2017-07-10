package mvc;

import java.io.IOException;
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
		//String parametro1 = request.getParameter("param");

		if(persistido){
		request.setAttribute("msgGeral", "Salvo com sucesso!");
		}
               
		request.getRequestDispatcher("new-event.jsp").
			forward(request, response);
                
     }
	
}
