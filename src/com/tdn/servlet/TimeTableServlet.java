package com.tdn.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdn.model.TimeTable;
import com.tdn.model.TimeTableDAO;

/**
 * Servlet implementation class TimeTableServlet
 */
@WebServlet("/TimeTable")
public class TimeTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeTableServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar calendar = Calendar.getInstance();
		// Date型に変換
		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);

        request.setAttribute("today", today);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timetableInsert.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uidStr = request.getParameter("uid");
		int uid = Integer.parseInt(uidStr);

		String dateStr = request.getParameter("date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp date = null;
		try {
			date = new Timestamp(sdf.parse(dateStr).getTime());
		} catch (ParseException e) {
			System.out.println("Birthdayエラー" + e.getMessage());
		}

		TimeTableDAO tDAO = new TimeTableDAO();
		tDAO.insert(new TimeTable(uid,date));
		response.sendRedirect("find");
	}

}
