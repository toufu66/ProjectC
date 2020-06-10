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
import javax.servlet.http.HttpSession;

import com.tdn.model.Admin;
import com.tdn.model.Gender;
import com.tdn.model.User;
import com.tdn.model.UserDAO;
import com.tdn.model.Userclass;

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
		HttpSession session=request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin != null) {
			try {
			request.setCharacterEncoding("UTF-8");
			//データの取得
			String uidStr =request.getParameter("uid");
			int uid =Integer.parseInt(uidStr);

			String name =request.getParameter("name");
			String ruby =request.getParameter("ruby");

			String gidStr =request.getParameter("gender");
			int gid =Integer.parseInt(gidStr);
			UserDAO udao = new UserDAO();
			ArrayList<Gender> gList =  udao.getGenderList();//new ArrayList<>();
			//System.out.print(gid);
			String genderstr = null;

			try {
				genderstr=gList.get(gid-1).getGender();
			}catch(IndexOutOfBoundsException e) {
				genderstr = "エラー";
				String errorMsg = "性別が取得できません。";
				request.setAttribute("emsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}

			if(genderstr.equals(null) || genderstr.equals("")) {
				genderstr = "エラー";
				String errorMsg = "性別が取得できません。";
				request.setAttribute("emsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}

			String uclassStr =request.getParameter("uclass");
			int uclass =Integer.parseInt(uclassStr);
			ArrayList<Userclass> userclassList = udao.getUserclassList();//new ArrayList<>();
			String uclassstr = null;
			try {
				uclassstr =  userclassList.get(uclass-1).getUclass();
			}catch(IndexOutOfBoundsException e) {
				uclassstr = "エラー";
				String errorMsg = "会員区分が取得できません。";
				request.setAttribute("emsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}

			if(uclassstr.equals(null) || genderstr.equals("")) {
				uclassstr = "エラー";
				String errorMsg = "会員区分が取得できません。";
				request.setAttribute("emsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}

			String birthdayStr =request.getParameter("birthday");

			String mail =request.getParameter("mail");

			String pointStr =request.getParameter("point");
			int point = 0;
			String pointError = "";
			try{
				point =Integer.parseInt(pointStr);
			}catch (NumberFormatException e) {
				pointError = "エラー";
				String errorMsg = "ポイントが正常ではありません。";
				request.setAttribute("emsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
			String password =request.getParameter("pass");

			request.setAttribute("uid",uid);
			request.setAttribute("name",name);
			request.setAttribute("ruby",ruby);
			request.setAttribute("gid", gid);
			request.setAttribute("genderstr", genderstr);
			request.setAttribute("uclassstr", uclassstr);
			request.setAttribute("birthday",birthdayStr);
			request.setAttribute("mail",mail);
			request.setAttribute("point",point);
			request.setAttribute("password",password);
			request.setAttribute("uclass",uclass);

			if(!genderstr.equals("エラー") && !uclassstr.equals("エラー") && !pointError.equals("エラー")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
				dispatcher.forward(request, response);
			}
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
		String uidStr =request.getParameter("uid");
		int uid =Integer.parseInt(uidStr);

		String name =request.getParameter("name");

		String ruby =request.getParameter("ruby");

		String gidStr =request.getParameter("gid");
		int gid =Integer.parseInt(gidStr);


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birthdayStr = request.getParameter("birthday");
		Timestamp birthday = null;
		try {
			birthday = new Timestamp(sdf.parse(birthdayStr).getTime());
		} catch (ParseException e) {
			System.out.println("Birthdayエラー" + e.getMessage());
		}

		String mail =request.getParameter("mail");

		String pointStr =request.getParameter("point");
		int point =Integer.parseInt(pointStr);

		String password =request.getParameter("password");

		String uClassStr =request.getParameter("uclass");

		int uClass =Integer.parseInt(uClassStr);


		UserDAO dao = new UserDAO();

		User u = new User(uid,name,ruby,gid,birthday,mail,point,password,uClass);
		dao.update(u);

		String RedirectUrl = "detail?uid=" + uid;
		response.sendRedirect(RedirectUrl);
	}

}
