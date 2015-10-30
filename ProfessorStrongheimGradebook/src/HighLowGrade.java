

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HighLowGrade
 */
@WebServlet("/HighLowGrade")
public class HighLowGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HighLowGrade() {
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
		out.println("<div class=\"panel-heading\" style=\"font-weight: bold;\">High Low Grade</div>");
		out.println("<div class=\"panel-body\">");
		String assignmenttype=request.getParameter("assignmenttype");
		try {
			Connection conn = UtilitiesDB.getConnection();
			String sql="select  ASSIGNMENT_TYPE, MAX(grade) as gradeMax, MIN(grade) as gradeMin from GRADEBOOK where ASSIGNMENT_TYPE=? group by ASSIGNMENT_TYPE";
			
		     PreparedStatement preStatement=conn.prepareStatement(sql);
		     
		     preStatement.setString(1, assignmenttype); 
		     
			 ResultSet result = preStatement.executeQuery();
			 out.println("<table class=\"table table-striped\">");
				out.println("<thead>");
				out.println("<tr>");
				out.println("<th>Assignment Type</th>");
				out.println("<th>Grade Highest</th>");
				out.println("<th>Grade Lowest</th>");
				out.println("</tr>");
				out.println("</thead>");
				out.println("<tbody>");
				while (result.next()){
					out.println("<tr><td>" +  result.getString("ASSIGNMENT_TYPE")+ "</td>");
					out.println("<td>" +  result.getString("gradeMax")+ "</td>");
					out.println("<td>" +  result.getString("gradeMin")+ "</td>");
					out.println("</tr>");
				
				}
				out.println("</table>");
				out.println("</div>");
				out.println("</div>");
				out.println("<a href = \"http://localhost:8080/ProfessorStrongheimGradebook/GradeForm.html\" type=\"submit\" class=\"btn btn-info\">Back</a>");
				out.println("</div>");
				out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
				out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script>");
				out.println("</body>");
				out.println("</html>");
				conn.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
