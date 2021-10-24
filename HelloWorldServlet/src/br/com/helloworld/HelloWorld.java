package br.com.helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/HelloWorld", "/index" })
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloWorld() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Date data = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		out.println("<!DOCTYPE html");
		out.println("<html lang='pt-br'>");
		out.println("<head>");
		out.println("<title>Hello World Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World Servlet</h1>");
		out.println("<p>LP2A4 - Linguagem de Programa��o 2</p>");
		out.println("<p>Data: ");
		out.println(df.format(data));
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
