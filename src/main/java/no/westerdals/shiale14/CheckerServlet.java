package no.westerdals.shiale14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * Created by Alexander Shipunov on 07.04.2016.
 */
public class CheckerServlet extends HttpServlet {

    private ServletProcessor processor = new PrimeNumberProcessor();
    final static Logger ERROR_LOG = LogManager.getLogger("errorLog");
    final static Logger REQUEST_LOG = LogManager.getLogger("requestLog");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String numberAsString = request.getParameter("number");
        String answer = processor.provideAnswer(numberAsString);

        request.setAttribute("answer", answer);
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            ERROR_LOG.error("Exception in servlet og IO functionality: ", e);
        }
    }

    public void setProcessor(ServletProcessor processor) {
        this.processor = processor;
    }
}
