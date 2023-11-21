<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--초회 기동시 북정보 저장--%>
<%
    //프라이빗 스태틱이 안됨
//    BookRepository bookList = new ArrayListRepo();
    ServletContext servletContext = config.getServletContext(); //상태저장하는 첫번째 방법
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "도서 관리 프로그램" %>
</h1>
<br/>
<a href=bookView.jsp title="도서 조회">  도서 조회</a>
<p></p>
<a href=bookSet.jsp title="도서 등록!!!!">  도서 등록</a>
<p></p>
<a href=bookRe.jsp title="도서 수정">  도서 수정</a>
<p></p>
<a href=bookDe.jsp title="도서 삭제(삭제는 신중히!!!)">  도서 삭제</a>
<p></p>

<a href=findnumber.jsp >  숫자 찾기</a>
<p></p>

</body>
</html>