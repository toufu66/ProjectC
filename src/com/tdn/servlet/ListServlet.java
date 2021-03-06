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
			String pageStr = "";
			try {
			pageStr = request.getParameter("page");

			if(pageStr.equals(null)|| pageStr.equals("")) {
				pageStr = "1";
			}
			int page = Integer.parseInt(pageStr);
			com.tdn.model.UserDAO dao= new com.tdn.model.UserDAO();
			ArrayList<User> ulist_ =dao.findUser("", "", null, null);
			int allListNum= ulist_.size();
			int divNum=10;//1ページに表示するリスト数
			int allPageNum=(int) Math.ceil(allListNum/(double) divNum);
			int allPageNum_=(int) Math.ceil((allListNum+1)/(double) divNum);
			//System.out.println(allListNum);
			//System.out.print(allPageNum);
			request.setAttribute("page", page);
			request.setAttribute("lastPage", allPageNum);
			request.setAttribute("listsize", allListNum);
			request.setAttribute("from", 1);
			//if(session.getAttribute("lastPage_")==null) {
				session.setAttribute("lastPage_",allPageNum_);
			//}
			ArrayList<User> ulist = new ArrayList<User>();
			//System.out.println(page!=allPageNum);
			if(ulist_.size() != 0) {
				if( page!=allPageNum) {
					for (int i = (page-1)*divNum;i< page*divNum;i++) {
						ulist.add(ulist_.get(i));
						}
				}else {
					//System.out.println((page-1)*divNum);
					//System.out.println(allListNum-((page-1)*divNum));
					for (int i = (page-1)*divNum; i < allListNum;i++) {
						//System.out.println(page);
						ulist.add(ulist_.get(i));
					}
			}

			}

			request.setAttribute("list", ulist);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);


			}catch(NullPointerException | NumberFormatException e) {
				String errorMsg = "ページ数が取得できません。";
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
