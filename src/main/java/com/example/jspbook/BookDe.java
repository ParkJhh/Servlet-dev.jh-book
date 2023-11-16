package com.example.jspbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BookDe")
public class BookDe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        if (BookSet.bookList.get(Long.parseLong(req.getParameter("bookid"))) != null) {
            BookSet.bookList.remove(Long.parseLong(req.getParameter("bookid")));
            out.println("도서 번호 " + req.getParameter("bookid") + "의 삭제가 완료되었습니다.");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookDe.jsp >[도서 삭제 페이지로]</a>");
        } else {
            out.println("삭제할 도서 정보가 없습니다. 다시 확인해 주십시오");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookDe.jsp >[도서 삭제 페이지로]</a>");
        }


    }
}
