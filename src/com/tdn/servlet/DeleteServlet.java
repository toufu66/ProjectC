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
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin != null) {
			try {

			request.setCharacterEncoding("UTF-8");
			String uidStr=request.getParameter("uid");
			int uid=Integer.parseInt(uidStr);


			if(uidStr==null) {
				response.sendRedirect("list");
				return;
			}

			UserDAO dao =new UserDAO();
			User u =dao.findByUid(uid);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birthday =sdf.format(u.getBirthday().getTime());

			ArrayList<Gender> gList =  dao.getGenderList();//new ArrayList<>();
			String genderstr=gList.get(u.getGid()-1).getGender();

			ArrayList<Userclass> userclassList = dao.getUserclassList();//new ArrayList<>();
			String uclassstr =  userclassList.get(u.getUclass()-1).getUclass();

			request.setAttribute("uid",uid);
			request.setAttribute("name",u.getName());
			request.setAttribute("ruby",u.getRuby());
			request.setAttribute("gid", u.getGid());
			request.setAttribute("genderstr", genderstr);
			request.setAttribute("uclassstr", uclassstr);
			request.setAttribute("birthday",birthday);
			request.setAttribute("mail",u.getMail());
			request.setAttribute("point",u.getPoint());
			request.setAttribute("password",u.getPassword());
			request.setAttribute("uclass",u.getUclass());

			request.setAttribute("user",u);

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/del.jsp");
			dispatcher.forward(request, response);
			}catch(NullPointerException | NumberFormatException e){
				String errorMsg = "ユーザ情報が取得できません。";
				request.setAttribute("emsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
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
		HttpSession session=request.getSession();
		String uidStr=request.getParameter("uid");
		int uid=Integer.parseInt(uidStr);

		UserDAO dao =new UserDAO();

		dao.delete(uid);

		//int lastpage = (int) session.getAttribute("lastPage_");
		String url="list?page="+ 1;//("lastPage");
		response.sendRedirect(url);
	}

}
