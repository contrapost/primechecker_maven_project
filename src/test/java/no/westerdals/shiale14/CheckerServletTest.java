package no.westerdals.shiale14;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * Created by Alexander Shipunov on 13.04.2016.
 */
public class CheckerServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher view;
    private PrimeNumberProcessor processor;

    @Before
    public void setUp(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        view = mock(RequestDispatcher.class);
        processor = mock(PrimeNumberProcessor.class);
    }

    @Test
    public void testApp() throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        when(request.getParameter("number")).thenReturn("3");
        when(request.getRequestDispatcher(anyString())).thenReturn(view);
        CheckerServlet servlet = new CheckerServlet();
        servlet.setProcessor(processor);

        servlet.doGet(request, response);

        verify(processor).provideAnswer("3");
        verify(view).forward(request, response);
    }
}