package com.tdn.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdn.model.User;
import com.tdn.model.UserDAO;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/find.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			UserDAO udao = new UserDAO();
			String searchStr = request.getParameter("search");
			int searchType = Integer.parseInt(searchStr);

			if(searchType == 0) {
				String uidStr = request.getParameter("uid");
				int uid = Integer.parseInt(uidStr);
				User user = udao.findByUid(uid);
				request.setAttribute("list", user);
			}else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String name = request.getParameter("name");
				String ruby = request.getParameter("ruby");
				String date1Str = request.getParameter("date1");
				String date2Str = request.getParameter("date2");
				Timestamp date1 = null;
				Timestamp date2 = null;


				if(date1Str.equals("") != true) {
					date1 = new Timestamp(sdf.parse(date1Str).getTime());
				}
				if(date1Str.equals("") != true) {
					date2 = new Timestamp(sdf.parse(date2Str).getTime());
				}

					ArrayList<User> userList = udao.findUser(name,ruby,date1,date2);
					request.setAttribute("list", userList);
			}


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);

			}catch(NumberFormatException | ParseException e){
				request.setAttribute("ferrormasg", e.getMessage());

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/find.jsp");
				dispatcher.forward(request, response);
			}
	}

}
