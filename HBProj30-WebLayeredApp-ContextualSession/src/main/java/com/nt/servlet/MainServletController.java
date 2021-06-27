package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.entity.InsurancePolicy;
import com.nt.service.IInsuranceService;
import com.nt.service.InsuranceServiceImpl;

@WebServlet("/controller")
public class MainServletController extends HttpServlet {

	private IInsuranceService ser;

	public MainServletController() {

		ser = new InsuranceServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println("MainServletController.doPost()  "+id);
		
		try {
			InsurancePolicy policy=ser.getDetails(id);
			req.setAttribute("policy", policy);
			System.out.println("Servlet "+policy);
			RequestDispatcher rd=req.getRequestDispatcher("/result.jsp");
			rd.forward(req, res);
			
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
	
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			doGet(req, res);
	}
	
	@Override
	public void destroy() {
		ser=null;
	}

}
