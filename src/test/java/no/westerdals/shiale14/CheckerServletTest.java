package no.westerdals.shiale14;

import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Test suit for CheckerServlet.
 *
 * Created by Alexander Shipunov on 13.04.2016.
 *
 * @see CheckerServlet CheckerServlet
 */
public class CheckerServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher view;
    private PrimeNumberProcessor processor;

    /**
     * Initializes necessary mock objects before each test running.
     */
    @Before
    public void setUp(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        view = mock(RequestDispatcher.class);
        processor = mock(PrimeNumberProcessor.class);
    }

    /**
     * Checks if the servlet uses instance of servlet processor and forwards
     * request and response using RequestDispatcher.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Test
    public void servletUsesServletProcessor() throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        when(request.getParameter("number")).thenReturn("3");
        when(request.getRequestDispatcher(anyString())).thenReturn(view);
        CheckerServlet servlet = new CheckerServlet();
        servlet.setProcessor(processor);

        servlet.doGet(request, response);

        verify(processor).provideAnswer("3");
        verify(view).forward(request, response);
    }

    /**
     * Checks if information about exception is logged in the error log
     * when the exception is thrown.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Test
    public void exceptionsRegisteredInErrorLog() throws ServletException, IOException {
        IOException e = mock(IOException.class);
        Logger logger = mock(Logger.class);
        response.setCharacterEncoding("UTF-8");
        when(request.getParameter("number")).thenReturn("3");
        when(request.getRequestDispatcher(anyString())).thenReturn(view);
        doThrow(e).when(view).forward(request, response);
        CheckerServlet servlet = new CheckerServlet();
        servlet.setErrorLogger(logger);

        servlet.doGet(request, response);

        verify(CheckerServlet.ERROR_LOG).error("Exception in servlet or IO functionality: ",
                e);
    }
}