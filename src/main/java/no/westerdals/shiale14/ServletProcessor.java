package no.westerdals.shiale14;

/**
 * Interface for different processors which can be used
 * with CheckerServlet to check user input and return
 * answer based on the input.
 *
 * Created by Alexander Shipunov on 15.04.2016.
 */
public interface ServletProcessor {

    /**
     * Returns a String that contains the answer for user request
     * based on a mechanism that has to be realized by class that
     * realizes the interface.
     *
     * @param input user input as String received by CheckerServlet
     * @return      a result of processing of user input as String
     */
    String provideAnswer(String input);

}
