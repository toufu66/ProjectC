package com.tdn.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tdn.model.Admin;
import com.tdn.model.Gender;
import com.tdn.model.User;
import com.tdn.model.UserDAO;
import com.tdn.model.Userclass;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
			request.setCharacterEncoding("UTF-8");
			String uidStr=request.getParameter("uid");
			int uid=Integer.parseInt(uidStr);

			UserDAO udao =new UserDAO();
			User u =udao.findByUid(uid);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String userBirthday = sdf.format(u.getBirthday());

			ArrayList<Gender> gList = udao.getGenderList();//new ArrayList<>();
			//gList = udao.getGenderList();

			ArrayList<Userclass> userclassList = udao.getUserclassList(); //new ArrayList<>();
			//userclassList = udao.getUserclassList();

			//String uclass = (String) request.getParameter("uclass");
					//(int) Integer.parseInt();


			request.setAttribute("user",u);
			request.setAttribute("birthday", userBirthday);
			request.setAttribute("glist", gList);
			request.setAttribute("uclist", userclassList);
			//request.setAttribute("uclass", uclass);
			//request.setAttribute("gid", gid);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp");
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
