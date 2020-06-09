package com.tdn.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tdn.model.User;
import com.tdn.model.UserDAO;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String admin = (String) session.getAttribute("admin");
		if(admin != null) {

			request.setCharacterEncoding("UTF-8");
			String uidStr=request.getParameter("uid");
			int uid=Integer.parseInt(uidStr);


			if(uidStr==null) {
				response.sendRedirect("list");
				return;
			}

			UserDAO dao =new UserDAO();
			User u =dao.findByUid(uid);
			request.setAttribute("user",u);

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/del.jsp");
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
		request.setCharacterEncoding("UTF-8");
		String uidStr=request.getParameter("uid");
		int uid=Integer.parseInt(uidStr);

		UserDAO dao =new UserDAO();

		dao.delete(uid);

		response.sendRedirect("list");
	}

}
