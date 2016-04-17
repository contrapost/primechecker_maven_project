package no.westerdals.shiale14;

import static org.apache.commons.math3.primes.Primes.isPrime;

/**
 * <p>
 * Simple servlet processor that checks if a number inserted by user
 * is a prime or not.
 * </p>
 * <p>
 * Created by Alexander Shipunov on 14.04.2016.
 * </p>
 * @see CheckerServlet CheckerServlet
 */
public class PrimeNumberProcessor implements ServletProcessor {

    /**
     * <p>
     *     Returns a String that contains a result of check of a number that was inserted
     *     by user of CheckerServlet. Answer can be either that the number is prime or not,
     *     or that the input was invalid.
     * </p>
     * <p>
     *     There are two types of invalid input. The first type presents the situation
     *     when user inserts a string that cannot be parsed to integer. In this case
     *     the method will throw the NumberFormatException that will be caught and
     *     logged in the error log. User will receive a message with information
     *     about a valid input.
     * </p>
     * <p>
     *     The second type represents the situation when
     *     user inserts a negative number or a number smaller than 2. In this case
     *     user receives a message with information about integers that can be checked.
     * </p>
     *
     * @param input Input that was received by CheckerServlet from user.
     * @return      A result of checking of user input as String
     */
    @Override
    public String provideAnswer(String input){
        String answer;
        int number;
        try{
            number = Integer.parseInt(input);
            CheckerServlet.REQUEST_LOG.info("Requested number: " + number);
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
            CheckerServlet.ERROR_LOG.error("Wrong format of input: ", nfe);
            answer = input + " is invalid input. Please insert a positive integer (max value is 2147483647).";
        }
        return answer;
    }
}
