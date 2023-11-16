<%--
  Created by IntelliJ IDEA.
  User: kitri
  Date: 2023-11-16
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>도서 등록 페이지</title>
</head>
<body>
    <h1> 도서 등록 페이지 </h1>
    <a href=http://localhost:8080/jsp_book_war_exploded/ >  1)메인 페이지로</a>
    <p></p>
    <a href=http://localhost:8080/jsp_book_war_exploded/bookView.jsp >  2)도서 조회 페이지로</a>
    <p></p>
    <a href=http://localhost:8080/jsp_book_war_exploded/bookRe.jsp >  3)도서 수정 페이지로</a>
    <p></p>
    <a href=http://localhost:8080/jsp_book_war_exploded/bookDe.jsp >  4)도서 삭제 페이지로</a>
    <p></p>
    <hr>
    <h1> 도서 등록은 여기서! </h1>
    <form  action="BookSet" method="post">
        <label>책 타입 : </label>
        <select name="booktype">
                <option value="Book"> 북 타입(기본형) </option>
                <option value="eBook"> e북 타입(파일 사이즈 추가) </option>
                <option value="audioBook"> audio북 타입(파일 사이즈, 언어, 재생시간 추가) </option>
        </select>
        <br>
        <label> id : </label>
        <input type="text" name="bookid" id="bookid">
        <br>
        <label> 제목 : </label>
        <input type="text" name="bookname" id="bookname">
        <br>
        <label> 저자 : </label>
        <input type="text" name="bookwriter" id="bookwriter">
        <br>
        <label> isbn : </label>
        <input type="text" name="isbn" id="isbn">
        <br>
        <label> 출판일 : </label>
        <input type="text" name="publishdate" id="publishdate">
        <br>
        <label> 파일크기 : </label>
        <input type="text" name="filesize" id="filesize">
        <br>
        <label> 재생언어 : </label>
        <input type="text" name="language" id="language">
        <br>
        <label> 재생시간 : </label>
        <input type="text" name="playtime" id="playtime">
        <br>
        <input type="submit" value="등록하기">
    </form>
</body>
</html>
