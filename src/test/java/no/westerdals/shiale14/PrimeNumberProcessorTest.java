package no.westerdals.shiale14;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test suit for PrimeNumberProcessor.
 *
 * Created by Alexander Shipunov on 14.04.2016.
 *
 * @see PrimeNumberProcessor PrimeNumberProcessor
 */
public class PrimeNumberProcessorTest {

    private PrimeNumberProcessor processor;

    /**
     * Initializes a processor before each test running.
     */
    @Before
    public void setUp(){
        processor = new PrimeNumberProcessor();
    }

    /**
     * Checks if the valid input returns correct answer, i.e. informs user
     * if the number that was inserted is prime or not.
     */
    @Test
    public void validInputGivesIntendedResult(){
        String prime = "5";
        String composite = "10";
        String positiveAnswer = " is a prime number.";
        String negativeAnswer = " isn't a prime number.";
        assertEquals(prime + positiveAnswer, processor.provideAnswer(prime));
        assertEquals(composite + negativeAnswer, processor.provideAnswer(composite));
    }

    /**
     * Checks if input of negative number or 0 or 1 results in an error message.
     */
    @Test
    public void invalidIntegerInputGivesErrorMessage(){
        String negative = "-9";
        String zero = "0";
        String one = "1";
        String errorMessage = "Prime number cannot be negative, 0 or 1.";
        assertEquals(errorMessage, processor.provideAnswer(negative));
        assertEquals(errorMessage, processor.provideAnswer(zero));
        assertEquals(errorMessage, processor.provideAnswer(one));
    }

    /**
     * Checks if alphabetic input results in error message that explains
     * what type of input is acceptable.
     */
    @Test
    public void alphabeticInputGivesErrorMessage(){
        String alphabeticInput = "number";
        String errorMessage = " is invalid input. Please insert a positive integer (max value is 2147483647).";
        assertEquals(alphabeticInput + errorMessage, processor.provideAnswer(alphabeticInput));
    }

    /**
     * Checks if large input results in error message that explains
     * what type of input is acceptable.
     */
    @Test
    public void largeInputGivesErrorMessage(){
        long one = 1;
        long longNumber = Integer.MAX_VALUE + one;
        // value of longNumber is 2147483648 (1 plus max value of integer)
        String moreThanInteger = "" + longNumber;
        String errorMessage = " is invalid input. Please insert a positive integer (max value is 2147483647).";
        assertEquals(moreThanInteger + errorMessage, processor.provideAnswer(moreThanInteger));
    }
}
