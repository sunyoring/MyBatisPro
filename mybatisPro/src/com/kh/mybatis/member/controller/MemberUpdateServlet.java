package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.model.service.MemberService;
import com.kh.mybatis.member.model.service.MemberServiceImpl;
import com.kh.mybatis.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/update.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService = new MemberServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String userPwd = ((Member)request.getSession().getAttribute("loginUser")).getUserPwd();
		String userName =((Member)request.getSession().getAttribute("loginUser")).getUserName();
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setUserName(userName);
		m.setEmail(email);
		m.setBirthday(birthday);
		m.setGender(gender);
		m.setPhone(phone);
		m.setAddress(address);
		

		
		
		try {
			memberService.updateMember(m);
			
			Member loginUser = memberService.loginMember(m);
			if(loginUser != null) {
				request.getSession().setAttribute("loginUser", loginUser);
			}

			response.sendRedirect(request.getContextPath());
			
	
		} catch (Exception e) {

			request.setAttribute("msg", "???????????? ??????");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			
			e.printStackTrace();
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
