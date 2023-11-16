<%@ page import="com.example.jspbook.Book" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.example.jspbook.BookSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: kitri
  Date: 2023-11-16
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

%>
<!doctype html>
<html lang="en">
<head>
    <title>도서 조회 페이지</title>
</head>
<body>
    <h1> 도서 조회 페이지 </h1>
    <a href=http://localhost:8080/jsp_book_war_exploded/ >  1)메인 페이지로</a>
    <p></p>
    <a href=http://localhost:8080/jsp_book_war_exploded/bookSet.jsp >  2)도서 등록 페이지로</a>
    <p></p>
    <a href=http://localhost:8080/jsp_book_war_exploded/bookRe.jsp >  3)도서 수정 페이지로</a>
    <p></p>
    <a href=http://localhost:8080/jsp_book_war_exploded/bookDe.jsp >  4)도서 삭제 페이지로</a>
    <p></p>
    <hr>
    <h1> 도서 조회는 여기서! 아래 첫번째 항목은 필수로 선택하셔야 합니다</h1>
    <form action="BookView" method="get">
    <select name="View" style="font-size: 18px">
        <div>
        <option value="allView"> (1)전체 조회 </option>
        <option value="nameView"> (2)책 제목으로 조회</option>
        <option value="nameupView"> (3)책 제목 사전순으로 조회 </option>
        <option value="dateView"> (4)출간일 기간으로 조회 </option>
        <option value="dateupView"> (5)출간일 순으로 조회(오름차순) </option>
        <option value="sameView"> (6)중복 책 조회 </option>
        </div>
    </select>
        <hr><br>
        <label style="font-size: 18px">(2) 책 제목으로 조회하시는 경우 이곳에 입력하세요</label>
        <br>
        <label style="font-size: 15px"> 책 제목 : </label>
        <input type="text" name="searchname" id="searchname">
        <hr><br>

        <label style="font-size: 18px">(4) 출간일 기간으로 조회하시는 경우 이곳에 입력하세요</label>
        <br>
        <label style="font-size: 15px"> 시작일 :  </label>
        <input type="date" name="startdate" id="startdate">
        <label style="font-size: 15px"> 종료일 :  </label>
        <input type="date" name="enddate" id="enddate">
        <hr><br>

        <input type="submit" value="조회하기">
    </form>
</body>
</html>
