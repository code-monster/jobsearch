<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@tag pageEncoding="UTF-8"%>
<%@attribute name="title"%>
<%@attribute name="content" fragment="true"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="<c:url  value="/static/css/foundation.min.css" />" rel="stylesheet">
        <link href="<c:url  value="/static/css/foundation-icons.css" />" rel='stylesheet'>
        <link href="<c:url  value="/static/css/app.css" />" rel="stylesheet">
        <title>${title}</title>
    </head>
    <body>
        <header>
            <div class="row">
                <div class="large-4 columns">

                    <h3><a href="<c:url value="/"/>">Java Job Search</a></h3>
                </div>
                <div class="large-4 columns">
                    <ul class="menu">
                        <li><input type="search" placeholder="Search"></li>
                        <li>
                            <button type="button" class="button">Search</button>
                        </li>
                    </ul>
                </div>
                <div class="large-4 columns login-column">
                         <jsp:include page="/WEB-INF/jsp/menu.jsp" flush="true" />
                </div>
            </div>
        </header>
        <article>
            <jsp:invoke fragment="content" />
        </article>
        <footer>
            <div class="row">
                <span class="copyright">©2017 JavaJobSearch</span>
            </div>
        </footer>
    </body>
</html>