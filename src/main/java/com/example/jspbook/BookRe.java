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

@WebServlet("/BookRe")
public class BookRe extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        if (BookSet.bookList.get(Long.parseLong(req.getParameter("bookid"))) != null) {
            if(req.getParameter("booktype").equals("Book")) {
                String[] bookInfo = new String[5];
                bookInfo[0] = req.getParameter("bookid");
                bookInfo[1] = req.getParameter("bookname");
                bookInfo[2] = req.getParameter("bookwriter");
                bookInfo[3] = req.getParameter("isbn");
                bookInfo[4] = req.getParameter("publishdate");
                try{
                    LocalDate LocalDateErr = LocalDate.parse(bookInfo[4]);
                }
                catch (DateTimeParseException e) {
                    out.println("입력된 날짜 형식이 틀렸습니다." + e.getMessage());
                    return;
                }
                // book타입 저장
                Book book = new Book(Long.parseLong(bookInfo[0]),
                        bookInfo[1],
                        bookInfo[2],
                        Long.parseLong(bookInfo[3]),
                        LocalDate.parse(bookInfo[4]));
                BookSet.bookList.put(Long.parseLong(bookInfo[0]), book);
                out.println("북 타입 도서 수정이 완료 되었습니다.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookRe.jsp >[도서 수정 페이지로]</a>");
            } else if(req.getParameter("booktype").equals("eBook")){
                String[] bookInfo = new String[6];
                bookInfo[0] = req.getParameter("bookid");
                bookInfo[1] = req.getParameter("bookname");
                bookInfo[2] = req.getParameter("bookwriter");
                bookInfo[3] = req.getParameter("isbn");
                bookInfo[4] = req.getParameter("publishdate");
                bookInfo[5] = req.getParameter("filesize");
                try {
                    long IdErr = Long.parseLong(bookInfo[0]);
                    long IsbnErr = Long.parseLong(bookInfo[3]);
                    LocalDate LocalDateErr = LocalDate.parse(bookInfo[4]);
                    long FileSizeErr = Long.parseLong(bookInfo[5]);
                } catch (NumberFormatException e) {
                    out.println("id, isbn, 파일크기는 숫자만 입력 가능합니다" + e.getMessage());
                    return;
                } catch (DateTimeParseException e) {
                    out.println("입력된 날짜 형식이 틀렸습니다." + e.getMessage());
                    return;
                }
                // Ebook타입 저장
                EBook Ebook = new EBook(Long.parseLong(bookInfo[0]),
                        bookInfo[1],
                        bookInfo[2],
                        Long.parseLong(bookInfo[3]),
                        LocalDate.parse(bookInfo[4]),
                        Long.parseLong(bookInfo[5]));
                BookSet.bookList.put(Long.parseLong(bookInfo[0]), Ebook);
                out.println("e북 타입 도서 수정이 완료 되었습니다.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookRe.jsp >[도서 수정 페이지로]</a>");
            } else if(req.getParameter("booktype").equals("audioBook")){
                String[] bookInfo = new String[8];
                bookInfo[0] = req.getParameter("bookid");
                bookInfo[1] = req.getParameter("bookname");
                bookInfo[2] = req.getParameter("bookwriter");
                bookInfo[3] = req.getParameter("isbn");
                bookInfo[4] = req.getParameter("publishdate");
                bookInfo[5] = req.getParameter("filesize");
                bookInfo[6] = req.getParameter("language");
                bookInfo[7] = req.getParameter("playtime");
                try {
                    long IdErr = Long.parseLong(bookInfo[0]);
                    long IsbnErr = Long.parseLong(bookInfo[3]);
                    LocalDate LocalDateErr = LocalDate.parse(bookInfo[4]);
                    long FileSizeErr = Long.parseLong(bookInfo[5]);
                    Integer PlayTimeErr = Integer.parseInt(bookInfo[7]);
                } catch (NumberFormatException e) {
                    out.println("id,isbn,파일크기,재생시간은 숫자만 입력 가능합니다" + e.getMessage());
                    return;
                } catch (DateTimeParseException e) {
                    out.println("입력된 날짜 형식이 틀렸습니다." + e.getMessage());
                    return;
                }
                // AudioBook타입 저장
                AudioBook audioBook = new AudioBook(Long.parseLong(bookInfo[0]),
                        bookInfo[1],
                        bookInfo[2],
                        Long.parseLong(bookInfo[3]),
                        LocalDate.parse(bookInfo[4]),
                        Long.parseLong(bookInfo[5]),
                        bookInfo[6],
                        Integer.parseInt(bookInfo[7]));
                BookSet.bookList.put(Long.parseLong(bookInfo[0]), audioBook);
                out.println("audio북 타입 도서 수정이 완료 되었습니다.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookRe.jsp >[도서 수정 페이지로]</a>");
            } else {
                out.println("북 타입이 불일치 합니다. 다시 확인하여 주십시오.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookRe.jsp >[도서 수정 페이지로]</a>");
            }
        } else {
            out.println("수정할 도서 정보가 없습니다. 다시 확인해 주십시오");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookRe.jsp >[도서 삭제 페이지로]</a>");
        }

    }

}
