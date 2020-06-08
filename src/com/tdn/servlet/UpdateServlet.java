package com.tdn.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdn.model.User;
import com.tdn.model.UserDAO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uidStr =request.getParameter("uid");
		int uid =Integer.parseInt(uidStr);
		String name =request.getParameter("name");
		String ruby =request.getParameter("ruby");
		String gidStr =request.getParameter("gender");
		int gid =Integer.parseInt(gidStr);
		String uclassStr =request.getParameter("uclass");
		int uclass =Integer.parseInt(uclassStr);
		String birthdayStr =request.getParameter("birthday");
		Date birthday = Date.valueOf(birthdayStr);
		String mail =request.getParameter("mail");
		String pointStr =request.getParameter("point");
		int point =Integer.parseInt(pointStr);
		String password =request.getParameter("pass");

		request.setAttribute("uid",uid);
		request.setAttribute("name",name);
		request.setAttribute("ruby",ruby);
		request.setAttribute("gid",gid);
		request.setAttribute("uclass",uclass);
		request.setAttribute("birthday",birthday);
		request.setAttribute("mail",mail);
		request.setAttribute("point",point);
		request.setAttribute("password",password);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uidStr =request.getParameter("uid");
		int uid =Integer.parseInt(uidStr);
		String name =request.getParameter("name");
		String ruby =request.getParameter("ruby");
		String gidStr =request.getParameter("gid");
		int gid =Integer.parseInt(gidStr);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String birthdayStr = request.getParameter("birthday");
		Timestamp birthday = null;


		String mail =request.getParameter("mail");
		String pointStr =request.getParameter("point");
		int point =Integer.parseInt(pointStr);
		String password =request.getParameter("password");
		String uClassStr =request.getParameter("uClass");
		int uClass =Integer.parseInt(uClassStr);




		UserDAO dao = new UserDAO();
		User u = new User(uid,name,ruby,gid,birthday,mail,point,password,uClass);
		dao.update(u);

		response.sendRedirect("ulist");
	}

}
