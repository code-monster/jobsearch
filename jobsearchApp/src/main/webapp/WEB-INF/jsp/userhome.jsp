<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:general_form title="home">
    <jsp:attribute name="content">
            
        <div class="row">
            <div class="large-12 columns">

                <c:out value="${title}" />

                <div class="panel-body">

                    <p>Welcome, <c:out value="${username}"/>!</p>

                </div>
            </div>
        </div>

    </jsp:attribute>
</t:general_form>

