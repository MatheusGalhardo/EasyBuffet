package mvc;

import java.io.IOException;
import static java.lang.System.out;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/easybuffet/newevent")
public class EventoControler extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//String parametro1 = request.getParameter("param");

		
		//request.setAttribute("msgGeral", msgGeral);
                
		request.getRequestDispatcher("new-event.html").
			forward(request, response);
                
     }
	
}
