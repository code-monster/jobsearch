<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <ul class="nav in" id="side-menu">
        <sec:authorize access="!hasAnyAuthority('admin','client')"> 
            <li><a href="<c:url value="/login/"/>">Login</a></li>
            </sec:authorize>  

        <sec:authorize access="hasAnyAuthority('admin','client')"> 
            <li>
                <a href="<c:url value="/userhome"/>">User profile</a>
            </li>
            <li>
                <a href="<c:url value="/parsersetting"/>">Parser setting</a>
            </li>
            <li>
                <a href="<c:url value="/log"/>">Log entries</a>
            </li>
            <li>
                <a href="<c:url value="/logout"/>">Log out</a>
            </li>
        </sec:authorize>  
    </ul>
