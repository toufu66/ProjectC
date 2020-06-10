package com.tdn.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tdn.model.Admin;
import com.tdn.model.User;

/**
 * Servlet implementation class List_Servlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
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
			int page = Integer.parseInt(request.getParameter("page"));
			com.tdn.model.UserDAO dao= new com.tdn.model.UserDAO();
			ArrayList<User> ulist_ =dao.findUser("", "", null, null);
			int allListNum= ulist_.size();
			int allPageNum=(int) Math.ceil(allListNum/50.);
			request.setAttribute("page", page);
			request.setAttribute("lastPage", allPageNum);

			ArrayList<User> ulist = new ArrayList<User>();

			if( page!=allPageNum) {
				for (int i = (page-1)*50;i< page*50;i++) {
					ulist.add(ulist.get(i));
					}
			}else {
				for (int i = (page-1)*50;i< allListNum-((page-1)*50);i++) {
					ulist.add(ulist_.get(i));
				}

			}

			request.setAttribute("list", ulist);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
