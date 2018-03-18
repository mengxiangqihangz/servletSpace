package com.mvc.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.mvc.bean.BankCustomer;

// http://localhost:8080/MVC/showBalance?id=id001

@WebServlet(urlPatterns={"/showBalance"})
public class ShowBalance  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BankCustomer customer = BankCustomer.getCustomer(req.getParameter("id"));
		String address;
		if(customer==null){
			address = "/WEB-INF/bank-account/UnknownCustomer.jsp";
		}else if(customer.getBalance()<0){
			address = "/WEB-INF/bank-account/NegativeBalance.jsp";
			req.setAttribute("badCustomer", customer);
		}else if(customer.getBalance()<10000){
			address = "/WEB-INF/bank-account/NormalBalance.jsp";
			req.setAttribute("regularCustomer", customer);
		}else{
			address = "/WEB-INF/bank-account/HighBalance.jsp";
			req.setAttribute("eliteCustomer", customer);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(address);
		dispatcher.forward(req, resp);
		
	}
	
}
