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

        ArrayList<Evento> eventos = new ArrayList();
        Evento ev = new Evento();
        Evento ev1 = new Evento();
        ev.setNomeEvento("Oi Yago");
        ev.setDataString(Utilitarios.converteDataCalendar(Calendar.getInstance(), true));
        ev1.setNomeEvento("Teste Yago");
        ev1.setDataString(Utilitarios.converteDataCalendar(Calendar.getInstance(), true));

        eventos.add(ev);
        eventos.add(ev1);

        request.setAttribute("listaEventos", eventos);

        request.getRequestDispatcher("events.jsp").
            forward(request, response);

     }

}