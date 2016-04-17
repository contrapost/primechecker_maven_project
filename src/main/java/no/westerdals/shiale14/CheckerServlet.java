package no.westerdals.shiale14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * <p>
 * Universal servlet that receives user input and generate answer based on
 * a particular implementation of ServletProcessor interface.
 * </p>
 * <p>
 * Created by Alexander Shipunov on 07.04.2016.
 * </p>
 * @see ServletProcessor ServletProcessor.
 * @see PrimeNumberProcessor PrimeNumberProcessor.
 */
public class CheckerServlet extends HttpServlet {

    // PrimeNumberProcessor can be changed with another type of processor
    // depending on user needs.
    private ServletProcessor processor = new PrimeNumberProcessor();
    static Logger ERROR_LOG = LogManager.getLogger("errorLog");
    static Logger REQUEST_LOG = LogManager.getLogger("requestLog");

    /**
     * <p>
     * Receives user input, generate answer with the help of a particular
     * implementation of a ServletProcessor and displays the answer using
     * RequestDispatcher.
     * </p>
     * <p>
     * IOExceptions and ServletExceptions are logged in the error log.
     * </p>
     * @param request   HttpServletRequest request.
     * @param response  HttpServletResponse response.
     */
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
            ERROR_LOG.error("Exception in servlet or IO functionality: ", e);
        }
    }

    /**
     * Setter that can be used to set other processor.
     * @param processor object of implementation of ServletProcessor interface.
     */
    void setProcessor(ServletProcessor processor) {
        this.processor = processor;
    }

    /**
     * Setter that can be used to set error log.
     * @param errorLogger object of Logger class.
     */
    void setErrorLogger(Logger errorLogger){
        ERROR_LOG = errorLogger;
    }
}
