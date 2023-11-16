package com.example.jspbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

@WebServlet("/BookView")
public class BookView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String InputNumber = req.getParameter("View");

        if (InputNumber.equals("allView")) {
            out.println("전체 조회 결과");
            out.println("<hr>");

            //Bookset 서블릿에 있는 bookList의 밸류를 books로 담음
            Collection<Book> books = BookSet.bookList.values();
            //books를 arraylist로 생성하여 booklist1에 담음
            List<Book> bookList1 = new ArrayList<>(books);
            //기존 for문을 활용하여 전체 조회
            for (Book bookval : bookList1) {
                out.println(bookval.toString());
                out.println("<p></p>");
            }
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookView.jsp >[도서 조회 페이지로]</a>");
        } else if (InputNumber.equals("nameView")) {
           if(req.getParameter("searchname") == null){
               out.println("책 제목을 입력해 주세요");
               out.println("<p></p>");
               out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookView.jsp >[도서 조회 페이지로]</a>");
           } else {
               out.println("책 제목 조회 결과");
               out.println("<hr>");

               Collection<Book> books = BookSet.bookList.values();
               List<Book> bookList1 = new ArrayList<>(books);

               for (Book bookval : bookList1) {
                   if (bookval.getName().toLowerCase().contains(req.getParameter("searchname"))) {
                       out.println(bookval);
                       out.println("<p></p>");
                   }
               }
               out.println("<p></p>");
               out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
               out.println("<p></p>");
               out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookView.jsp >[도서 조회 페이지로]</a>");
           }
        } else if (InputNumber.equals("nameupView")) {
            out.println("책 제목 사전순 조회 결과");
            out.println("<hr>");
            Collection<Book> books = BookSet.bookList.values();
            List<Book> bookList1 = new ArrayList<>(books);

            bookList1.sort((o1, o2) -> o1.getName().toLowerCase().compareTo(o2.getName()));
            for (Book bookval : bookList1) {
                out.println(bookval.toString());
                out.println("<p></p>");
            }
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookView.jsp >[도서 조회 페이지로]</a>");
        } else if (InputNumber.equals("dateView")) {
            out.println("출판일 기간 조회 결과");
            out.println("<hr>");

            Collection<Book> books = BookSet.bookList.values();
            List<Book> bookList1 = new ArrayList<>(books);
            for (Book bookval : bookList1) {
                if (bookval.getPublishedDate().isBefore(LocalDate.parse(req.getParameter("enddate"))) &&
                        bookval.getPublishedDate().isAfter(LocalDate.parse(req.getParameter("startdate")))) {
                    out.println(bookval);
                    out.println("<p></p>");
                }
            }
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookView.jsp >[도서 조회 페이지로]</a>");
        }else if (InputNumber.equals("dateupView")) {
            out.println("출간일 순 조회(오름차순) 결과");
            Collection<Book> books = BookSet.bookList.values();
            List<Book> bookList1 = new ArrayList<>(books);

            bookList1.sort((o1, o2) -> o1.getPublishedDate().compareTo(o2.getPublishedDate()));
            for (Book bookval : bookList1) {
                out.println(bookval.toString());
                out.println("<p></p>");
            }
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookView.jsp >[도서 조회 페이지로]</a>");
        } else if(InputNumber.equals("sameView")) {
            out.println("상호 중복 도서(제목,저자,isbn이 같습니다.)");
            out.println("<hr>");
            Set<Long> keyset = BookSet.bookList.keySet();
            Iterator<Long> iterator = keyset.iterator();
            //중복 카운트용
            int count = 0;
            for (Long key : BookSet.bookList.keySet()) {
                Book bookval = BookSet.bookList.get(key);
                while (iterator.hasNext()) {
                    Long itKey = iterator.next();
                    Book bookval1 = BookSet.bookList.get(itKey);
                    if (bookval.equals(bookval1) && !(key.equals(itKey))) {
                        if (bookval1.equals(bookval)) {
                            BookSet.samebookList.put(itKey,bookval);
                            count++;
                        }
                    }
                }
                iterator = keyset.iterator();
            }
            Collection<Book> books = BookSet.samebookList.values();
            List<Book> bookList1 = new ArrayList<>(books);
            for (Book bookval : bookList1) {
                out.println(bookval.toString());
                out.println("<p></p>");
            }
            out.println("중복 개수 : " + count / 2);
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookView.jsp >[도서 조회 페이지로]</a>");
        }
    }
}

