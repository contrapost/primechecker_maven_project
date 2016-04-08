package no.westerdals.shiale14;

import javax.servlet.RequestDispatcher;
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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String numberAsString = request.getParameter("number");
        int number;
        String answer;
        try{
            number = Integer.parseInt(numberAsString);
            if (number > 1) {
                if(isPrime(number)){
                    answer = number + " is prime";
                } else {
                    answer = number + " isn't prime";
                }
            } else {
                answer = "Prime number cannot be negative or equal 1";
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            answer = numberAsString + " is invalid input. Please insert a positive integer.";
        }

        request.setAttribute("answer", answer);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
