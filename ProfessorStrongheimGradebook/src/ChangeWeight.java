

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeWeight
 */
@WebServlet("/ChangeWeight")
public class ChangeWeight extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PreparedStatement preStatement;
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeWeight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println(" <div class=\"container\">");
		out.println("<div class=\"panel panel-default\">");
		out.println("<div class=\"panel-heading\" style=\"font-weight: bold;\">Assignment by Student</div>");
		out.println("<div class=\"panel-body\">");
		// we need to do required condition,with four type of assignment the input boxes should let professor enter the weights he want between 0-100 
		out.println("<form action = \"AssignmentbyStudent\" type= \"POST\">");
	    out.println(" <label for=\"inputGrade\">Homework:</label><input type=\"text\" name=\"Homework\" class=\"form-control\" placeholder=\"Between 0 and 100\" required ></input>");
		out.println(" <label for=\"inputGrade\">Quiz:</label><input type=\"text\" name=\"Quiz\" class=\"form-control\" placeholder=\"Between 0 and 100\" required></input>");
	    out.println(" <label for=\"inputGrade\">Test:</label><input type=\"text\" name=\"Test\" class=\"form-control\" placeholder=\"Between 0 and 100\" required></input>");
		out.println(" <label for=\"inputGrade\">Project:</label><input type=\"text\" name=\"Project\" class=\"form-control\" placeholder=\"Between 0 and 100\" required></input>");
		
		out.println("</br ><button>Submit</button>");
		out.println("</form>");
		out.println("</div>");
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
