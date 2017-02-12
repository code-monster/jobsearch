<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@attribute name="title"%>
<%@attribute name="content" fragment="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
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
                    <ul>
                        <sec:authorize access="!hasAnyAuthority('admin','client')"> 
                            <li><a href="<c:url value="/login/"/>">Login</a></li>
                        </sec:authorize>  

                        <sec:authorize access="hasAnyAuthority('admin','client')"> 
                            <li><a href="<c:url value="/userhome"/>">User profile</a> </li>
                            <li><a href="<c:url value="/logout"/>">Logout</a> </li>
                        </sec:authorize>

                    </ul>
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