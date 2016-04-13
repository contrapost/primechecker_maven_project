package no.westerdals.shiale14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.commons.math3.primes.Primes.isPrime;


/**
 *
 * Created by Alexander Shipunov on 07.04.2016.
 */
public class PrimeNumbersServlet extends HttpServlet {

    private final static Logger REQUEST_LOG = LogManager.getLogger("requestLog");
    private final static Logger ERROR_LOG = LogManager.getLogger("errorLog");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String numberAsString = request.getParameter("number");
        String answer;
        int number;

        try{
            number = Integer.parseInt(numberAsString);
            REQUEST_LOG.info("Requested number: " + number);
            if (number > 1) {
                if(isPrime(number)){
                    answer = number + " is a prime number.";
                } else {
                    answer = number + " isn't a prime number.";
                }
            } else {
                answer = "Prime number cannot be negative, 0 or 1.";
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            ERROR_LOG.error("Wrong format of input: ", nfe);
            answer = numberAsString + " is invalid input. Please insert a positive integer (max value is 2147483647).";
        }

        request.setAttribute("answer", answer);
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            ERROR_LOG.error("Exception in servlet og IO functionality: ", e);
            e.printStackTrace();
        }
    }
}
