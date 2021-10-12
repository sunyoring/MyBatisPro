package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.SearchCondition;
import com.kh.mybatis.common.Pagination;

/**
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/search.bo")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String condition = request.getParameter("condition");
		String search = request.getParameter("search");

		SearchCondition sc = new SearchCondition();

		switch (condition) {

		case "writer":
			sc.setWriter(search);
			break;

		case "title":
			sc.setTitle(search);
			break;
		case "content":
			sc.setContent(search);
			break;

		}

		try {
			int listCount = boardService.getListCountCon(sc);
			int currentPage = 1; // 현재 페이지
			int pageLimit = 10;
			int boardLimit = 5;

			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}

			PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);

			ArrayList<Board> list = boardService.selectListCon(sc, pi);

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);

			request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "검색 결과 불러오기 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
