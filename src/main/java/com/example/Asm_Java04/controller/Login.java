package com.example.Asm_Java04.controller;


//import com.example.Assignment.dao.DAO_Account;
//import com.example.Assignment.model.Account;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Login", value = {"/login"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/Login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        System.out.println(userName);


//        DAO_Account dao_account = new DAO_Account();
//        Account account = dao_account.getAccount(userName, password);
//
//        if (account == null) {
//            System.out.println(account.getUserName());
//            request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
//        } else {
////            if (account.getUserName().equals(userName) && account.getPassword().equals(password)) {
////                if(remember != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("acc", account);
//            System.out.println(account.getUserName());
//
//            response.sendRedirect("/home");


//                }
//                else{
//                    HttpSession session = request.getSession();
//                    session.removeAttribute("acc");
//                    request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
//
//                }


//                response.sendRedirect("/home");
//            }
//        else {
//                request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
//
//            }

//        }
    }
}
