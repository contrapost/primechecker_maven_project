package no.westerdals.shiale14;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Alexander Shipunov on 14.04.2016.
 */
public class ServletProcessorTest {

    private ServletProcessor processor;

    @Before
    public void setUp(){
        processor = new ServletProcessor();
    }

    @Test
    public void validInputGivesIntendedResult(){
        String prime = "5";
        String composite = "10";
        String positiveAnswer = " is a prime number.";
        String negativeAnswer = " isn't a prime number.";
        assertEquals(prime + positiveAnswer, processor.provideAnswer(prime));
        assertEquals(composite + negativeAnswer, processor.provideAnswer(composite));
    }
}
