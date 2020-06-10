package com.tdn.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tdn.model.Admin;
import com.tdn.model.User;
import com.tdn.model.UserDAO;


/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin != null) {


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/insert.jsp");
			dispatcher.forward(request, response);
		}else {
			String RedirectUrl = "login";
			response.sendRedirect(RedirectUrl);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String ruby = request.getParameter("ruby");
		String pass = request.getParameter("pass");
//		String passconfStr = request.getParameter("passconf");
		String gidStr = request.getParameter("gid");
		String uclassStr = request.getParameter("uclass");

		String birthdayStr = request.getParameter("birthday");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp birthday = null;
		try {
			birthday = new Timestamp(sdf.parse(birthdayStr).getTime());
		} catch (ParseException e) {
			System.out.println("Birthdayエラー" + e.getMessage());
		}

		int gid =Integer.parseInt(gidStr);
		int uclass =Integer.parseInt(uclassStr);
		UserDAO dao= new UserDAO();
		User u= new User (0,name,ruby,gid,birthday,mail,0,pass,uclass);
		dao.insert(u);
		String url="list?page="+(int) session.getAttribute("lastPage");//("lastPage");
		response.sendRedirect(url);
	}

}
