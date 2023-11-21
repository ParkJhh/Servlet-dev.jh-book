package com.example.jspbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-number")
public class findNumber extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String s = req.getParameter("input");
        String re = "";
        for(int i=0; i < s.length(); i++){
            if(String.valueOf(s.charAt(i)).matches("[0-9]+")){
                re += s.charAt(i);
            }
        }
        out.println(re);
        out.println("<hr>");
        out.println("<a href=http://localhost:8080/jsp_book_war_exploded/findnumber.jsp >[숫자 찾기 페이지로]</a>");
        out.println("<p></p>");
        out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");

    }
}
