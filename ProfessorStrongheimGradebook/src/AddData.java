

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddData
 */
@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private PreparedStatement preStatement;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String studentid=request.getParameter("studentid");
		String assignmentname=request.getParameter("assignmentname");
		String assignmenttpe=request.getParameter("assignmenttpe");
		String date=request.getParameter("date");	
		String Grade=request.getParameter("grade");
		out.println("<html>");
		
		
		try {
			Connection conn = UtilitiesDB.getConnection();
			Statement stmt = conn.createStatement();
		
		
			int result = stmt.executeUpdate( "INSERT INTO GRADEBOOK (STUDENT_ID,ASSIGNMENT_NAME,ASSIGNMENT_TYPE,ASSIGNMENT_DATE,GRADE) values ('"+studentid+"','" +assignmentname + "','" + assignmenttpe +"','" + date + "'," +Grade + ")");
			//ResultSet result1 = stmt.executeQuery("select * from STUDENT1" );
		
			out.println("<head>");
			out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">");
			out.println("</head>");
			out.println("<body>");
			out.println(" <div class=\"container\">");
			out.println("<div class=\"panel panel-default\">");
			out.println("<div class=\"panel-heading\" style=\"font-weight: bold;\">Professor Strongheim's Gradebook</div>");
			out.println("<div class=\"panel-body\">");
			if (result != 0){
				out.println("<div class=\"panel panel-default\">");
				out.println("<div class=\"panel-heading\" style=\"font-weight: bold;\">Show All Assignments by a Student</div>");
				out.println("<div class=\"panel-body\">");
				out.println("<form action = \"AssignmentbyStudent\" type= \"POST\">");
				out.println(" <label for=\"inputGrade\">Student ID:</label><input type=\"text\" name=\"studentid\" class=\"form-control\" placeholder=\"Student ID\" required></input>");
				out.println("</br ><button>Submit</button>");
				out.println("</form>");
				out.println("</div>");
				out.println("</div>");
				
				out.println("<div class=\"panel panel-default\">");
				out.println("<div class=\"panel-heading\" style=\"font-weight: bold;\">All assignments of a particular type by anyone</div>");
				out.println("<div class=\"panel-body\">");
				out.println("<form action = \"AssignmentbyType\" type= \"POST\">");
				out.println(" <input type=\"radio\" name=\"assignmenttpe\" id=\"Homework\" value=\"Homework\"><label for=\"Homework\"> Homework</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Quiz\" value=\"Quiz\">");
				out.println("<label for=\"Quiz\">Quiz</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Test\" value=\"Test\">");
				out.println("<label for=\"Test\">Test</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Project\" value=\"Project\">");
				out.println("<label for=\"Project\">Project</label><br>");
				out.println("<button>Submit</button>");
				out.println("</form>");
				out.println("</div>");
				out.println("</div>");
				
				out.println("<div class=\"panel panel-default\">");
				out.println("<div class=\"panel-heading\" style=\"font-weight: bold;\">All assignments of a particular type by a particular student</div>");
				out.println("<div class=\"panel-body\">");
				out.println("<form action = \"AssignmentbyStudentType\" type= \"POST\">");
				out.println(" <label for=\"inputGrade\">Student ID:</label><input type=\"text\" name=\"studentid\" class=\"form-control\" placeholder=\"Student ID\" required></input>");
				out.println(" <input type=\"radio\" name=\"assignmenttpe\" id=\"Homework\" value=\"Homework\"><label for=\"Homework\"> Homework</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Quiz\" value=\"Quiz\">");
				out.println("<label for=\"Quiz\">Quiz</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Test\" value=\"Test\">");
				out.println("<label for=\"Test\">Test</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Project\" value=\"Project\">");
				out.println("<label for=\"Project\">Project</label><br>");
				out.println("<button>Submit</button>");
				out.println("</form>");
				out.println("</div>");
				out.println("</div>");
				
				out.println("<div class=\"panel panel-default\">");
				out.println("<div class=\"panel-heading\" style=\"font-weight: bold;\">The average for a student</div>");
				out.println("<div class=\"panel-body\">");
				out.println("<form action = \"AverageforStudent\" type= \"POST\">");
				out.println(" <label for=\"inputGrade\">Student ID:</label><input type=\"text\" name=\"studentid\" class=\"form-control\" placeholder=\"Student ID\" required></input>");
				out.println("<button>Submit</button>");
				out.println("</form>");
				out.println("</div>");
				out.println("</div>");
				
				
				
				out.println("<div class=\"panel panel-default\">");
				out.println("<div class=\"panel-heading\" style=\"font-weight: bold;\">The average for a student by assignment type</div>");
				out.println("<div class=\"panel-body\">");
				out.println("<form action = \"AverageforStudentbyType\" type= \"POST\">");
				out.println(" <label for=\"inputGrade\">Student ID:</label><input type=\"text\" name=\"studentid\" class=\"form-control\" placeholder=\"Student ID\" required></input>");
				out.println(" <input type=\"radio\" name=\"assignmenttpe\" id=\"Homework\" value=\"Homework\"><label for=\"Homework\"> Homework</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Quiz\" value=\"Quiz\">");
				out.println("<label for=\"Quiz\">Quiz</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Test\" value=\"Test\">");
				out.println("<label for=\"Test\">Test</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Project\" value=\"Project\">");
				out.println("<label for=\"Project\">Project</label><br>");
				out.println("<button>Submit</button>");
				out.println("</form>");
				out.println("</div>");
				out.println("</div>");
				
				
				out.println("<div class=\"panel panel-default\">");
				out.println("<div class=\"panel-heading\" style=\"font-weight: bold;\">The highest and lowest grade for a particular assignment type</div>");
				out.println("<div class=\"panel-body\">");
				out.println("<form action = \"HighLowGrade\" type= \"POST\">");
				out.println(" <input type=\"radio\" name=\"assignmenttpe\" id=\"Homework\" value=\"Homework\"><label for=\"Homework\"> Homework</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Quiz\" value=\"Quiz\">");
				out.println("<label for=\"Quiz\">Quiz</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Test\" value=\"Test\">");
				out.println("<label for=\"Test\">Test</label><br>");
				out.println("<input type=\"radio\" name=\"assignmenttpe\" id=\"Project\" value=\"Project\">");
				out.println("<label for=\"Project\">Project</label><br>");
				out.println("<button>Submit</button>");
				out.println("</form>");
				out.println("</div>");
				out.println("</div>");
				
			}else {
				out.println("<h1>Failure Insert</h1>");
			}
			
			//out.println("<a href =\"http://localhost:8080/MackleberryGradebook/CalculateAvgGrade\">Show Average</a><br>");
			out.println("</div>");
			out.println("</div>");
			out.println("<a href = \"http://localhost:8080/ProfessorStrongheimGradebook/GradeForm.html\" type=\"submit\" class=\"btn btn-info\">Back</a>");
			out.println("</div>");
			out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
			out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script>");
			out.println("</body>");
			out.println("</html>");
			conn.close();

		} catch (Exception e) {

			String msg = e.getMessage();
			out.println("<p>" + msg);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
