package no.westerdals.shiale14;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 *
 * Created by Alexander Shipunov on 13.04.2016.
 */
public class PrimeNumbersServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher view;
    private PrimeNumbersServlet servlet;

    @Before
    public void setUp(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        view = mock(RequestDispatcher.class);
        servlet = mock(PrimeNumbersServlet.class);
    }



    @Test
    public void testApp() {
        assertTrue( true );
    }
}