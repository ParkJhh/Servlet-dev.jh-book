package com.example.jspbook;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//loadOnStartup => 서버가 기동되면서 이 서블릿이 가장 먼저 실행됨
@WebServlet(value = "/BookSet", loadOnStartup = 1)
public class BookSet extends HttpServlet {
    //데이터 저장용
    public static HashMap<Long, Book> bookList = new HashMap<>();
    //중복 카운팅용
    public static HashMap<Long, Book> samebookList = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookList.put(1L, new Book(1L,"부자아빠 가난한아빠", "로버트 키요사키", Long.parseLong("5791144331796"), LocalDate.parse("1999-02-15")));
        bookList.put(2L, new AudioBook(2L,"산마처럼 비웃는 것", "미쓰다 신조", Long.parseLong("0211129850369"), LocalDate.parse("2008-01-24"), 7500L, "일본어", 9999));
        bookList.put(3L, new EBook(3L,"K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2023-11-14"), 1000L));
        bookList.put(4L, new EBook(4L,"k 배터리 레볼루션", "박순자", Long.parseLong("9791191521221"), LocalDate.parse("2017-08-02"), 1000L));
        bookList.put(5L, new AudioBook(5L,"위기의 역사", "오건영", Long.parseLong("7711123000360"), LocalDate.parse("2023-07-19"), 5000L, "영어", 1234));
        bookList.put(6L, new EBook(6L,"탁류", "채만식", Long.parseLong("8791169021424"), LocalDate.parse("1974-05-28"), 1500L));
        bookList.put(7L, new Book(7L,"돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331795"), LocalDate.parse("2020-06-15")));
        bookList.put(8L, new Book(8L,"돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331795"), LocalDate.parse("2021-09-24")));
        bookList.put(9L, new Book(9L,"침묵의 퍼레이드", "히가시노 게이고", Long.parseLong("3211671290842"), LocalDate.parse("2023-11-02")));
        bookList.put(10L, new EBook(10L,"침묵의 퍼레이드", "히가시노 게이고", Long.parseLong("3211671290842"), LocalDate.parse("2022-02-14"),8000L));
        bookList.put(11L, new AudioBook(11L,"침묵의 퍼레이드", "히가시노 게이고", Long.parseLong("3211671290842"), LocalDate.parse("2022-02-14"), 8000L, "일본어",1234));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println(req.getParameter("booktype"));

        if (req.getParameter("booktype").equals("Book")) {
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
            if(BookSet.bookList.containsKey(Long.parseLong(req.getParameter("bookid")))){
                out.println("동일한 id가 존재합니다. 다시 확인해 주세요.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookSet.jsp >[도서 등록 페이지로]</a>");
            } else {
                Book book = new Book(Long.parseLong(bookInfo[0]),
                        bookInfo[1],
                        bookInfo[2],
                        Long.parseLong(bookInfo[3]),
                        LocalDate.parse(bookInfo[4]));
                bookList.put(Long.parseLong(bookInfo[0]), book);
                out.println("북 타입 도서 등록이 완료 되었습니다.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookSet.jsp >[도서 등록 페이지로]</a>");
            }
        } else if (req.getParameter("booktype").equals("eBook")) {
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
            if(BookSet.bookList.containsKey(Long.parseLong(req.getParameter("bookid")))){
                out.println("동일한 id가 존재합니다. 다시 확인해 주세요.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookSet.jsp >[도서 등록 페이지로]</a>");
            } else {
                EBook Ebook = new EBook(Long.parseLong(bookInfo[0]),
                        bookInfo[1],
                        bookInfo[2],
                        Long.parseLong(bookInfo[3]),
                        LocalDate.parse(bookInfo[4]),
                        Long.parseLong(bookInfo[5]));
                bookList.put(Long.parseLong(bookInfo[0]), Ebook);
                out.println("e북 타입 도서 등록이 완료 되었습니다.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookSet.jsp >[도서 등록 페이지로]</a>");
            }

        } else if (req.getParameter("booktype").equals("audioBook")) {
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
            if(BookSet.bookList.containsKey(Long.parseLong(req.getParameter("bookid")))){
                out.println("동일한 id가 존재합니다. 다시 확인해 주세요.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookSet.jsp >[도서 등록 페이지로]</a>");
            } else {
                AudioBook audioBook = new AudioBook(Long.parseLong(bookInfo[0]),
                        bookInfo[1],
                        bookInfo[2],
                        Long.parseLong(bookInfo[3]),
                        LocalDate.parse(bookInfo[4]),
                        Long.parseLong(bookInfo[5]),
                        bookInfo[6],
                        Integer.parseInt(bookInfo[7]));
                bookList.put(Long.parseLong(bookInfo[0]), audioBook);
                out.println("audio북 타입 도서 등록이 완료 되었습니다.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/ >[메인 페이지로]</a>");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/jsp_book_war_exploded/bookSet.jsp >[도서 등록 페이지로]</a>");
            }
        }
    }
}
