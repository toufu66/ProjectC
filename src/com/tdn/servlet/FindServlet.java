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
import com.tdn.model.UserDAO;


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

		HttpSession session=request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		String error=(String)session.getAttribute("finderrormsg");

		if(error !=null) {
			request.setAttribute("errormsg", error);
			session.removeAttribute("finderrormsg");
		}

		if(admin != null) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/find.jsp");
			dispatcher.forward(request, response);
		} else {
			String RedirectUrl = "login";
			response.sendRedirect(RedirectUrl);
			//RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			//dispatcher.forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();

		try {
			//DAOを用意
			UserDAO udao = new UserDAO();

			//サーチタイプを取得
			String searchStr = request.getParameter("search");
			int searchType = Integer.parseInt(searchStr);

			//サーチタイプを判別(0ならmid検索,1なら名前日付検索)
			if(searchType == 0) {

				//uidを取得
				String uidStr = request.getParameter("uid");
				int uid = Integer.parseInt(uidStr);
				//詳細ページへリダイレクト
				String RedirectUrl = "detail?uid="+uid;
				response.sendRedirect(RedirectUrl);


			}else {

				//日付定義
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//データ取得
				String name = request.getParameter("name");
				String ruby = request.getParameter("ruby");
				String date1Str = request.getParameter("date1");
				String date2Str = request.getParameter("date2");


				if(date1Str.equals("")) {
					date1Str = null;
				}
				if(date2Str.equals("")) {
					date2Str = null;
				}

					ArrayList<User> userList = udao.findUser(name,ruby,date1Str,date2Str);
					int listSize = userList.size();
					request.setAttribute("list", userList);
					request.setAttribute("date1", date1Str);
					request.setAttribute("date2", date2Str);
					request.setAttribute("listsize", listSize);
					request.setAttribute("from", 2);



					//list.jspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
					dispatcher.forward(request, response);
			}


			}catch(NumberFormatException e){
				String RedirectUrl = "find";
				String finderrorMsg = "ユーザIDが不正です。";

				session.setAttribute("finderrormsg", finderrorMsg);
				response.sendRedirect(RedirectUrl);
			}
	}

}
