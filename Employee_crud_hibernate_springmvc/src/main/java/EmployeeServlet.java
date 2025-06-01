

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.app.dao.EmployeeDao;
import com.app.entity.Employee;


public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private EmployeeDao dao;
   
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if("delete".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deteteEmp(id);
			response.sendRedirect("viewEmp.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		Employee e1 = new Employee();
		e1.setId(id);
		e1.setName(name);
		e1.setCity(city);
		dao.saveEmployee(e1);
		int flag = 1;
		PrintWriter out = response.getWriter();
		
		if(flag==1) {
			
			response.sendRedirect("viewEmp.jsp");
			out.print("<h2>employee add successfully</h2>");
		}
		
          
		
	
		
		doGet(request, response);
		
		
	}

}
