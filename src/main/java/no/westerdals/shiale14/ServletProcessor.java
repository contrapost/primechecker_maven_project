package no.westerdals.shiale14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.apache.commons.math3.primes.Primes.isPrime;

/**
 *
 * Created by Alexander Shipunov on 14.04.2016.
 */
public class ServletProcessor {

    private final static Logger REQUEST_LOG = LogManager.getLogger("requestLog");

    String provideAnswer(String input){
        String answer;
        int number;
        try{
            number = Integer.parseInt(input);
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
            PrimeNumbersServlet.ERROR_LOG.error("Wrong format of input: ", nfe);
            answer = input + " is invalid input. Please insert a positive integer (max value is 2147483647).";
        }
        return answer;
    }

}
