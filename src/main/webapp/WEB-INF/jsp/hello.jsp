<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<head>
<link rel="stylesheet" type="text/css"
 href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
 <c:url value="/css/main.css" var="jstlCss" />
 <link href="${jstlCss}" rel="stylesheet" />
    <meta charset="UTF-8">
    <title>GradeSheet!</title>
</head>
<body>
<div class="container">
<header>
			<h1>Student GradeSheet</h1>
		</header>
		<div class="starter-template">
<table class="table table-striped table-hover table-condensed table-bordered">
    <tr>
        <th>Student Name</th>
        <c:forEach var="user" items="${name}">
            <th>${user.sectionName}</th>
        </c:forEach>
    </tr>

            <c:forEach var="stu" items="${grade}">
                    <tr>
                            <td>${stu.studentName}</td>

                                 <jsp:useBean id="total" class="java.util.LinkedHashMap"/>
                                 <c:set var="count" value="0" />
                        <c:forEach var="stitr" items="${name}">
                        <td>

                        <c:forEach var="itr2" items="${stu.marks}">
                                 <c:if test = "${itr2.key == stitr.sectionId}">
                                 <c:set var="count" value="1" />
                                 <c:set var="gradePer" value="${itr2.value}" />
                                  </c:if>

                         </c:forEach>


                         <c:choose>
                             <c:when test="${count >0 }">
                                 ${gradePer}
                             </c:when>
                             <c:otherwise>
                                 00%
                             </c:otherwise>
                         </c:choose>

                        </td>

                         </c:forEach>

                         </tr>
             </c:forEach>


   </table>
   </div
   </div>
<script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>