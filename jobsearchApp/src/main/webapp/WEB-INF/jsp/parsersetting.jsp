<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:general_form title="home">
    <jsp:attribute name="content">

        <div class="row">
            <div class="large-12 columns">

                <h3>Parser modules:</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Action</th>
                            <th>Module</th>
                        </tr> 
                    </thead>
                    <tbody>
                        <c:forEach var="module"  items="${moduleList}"  varStatus="loop" >
                            <tr>
                                <td>  
                                    <c:choose>
                                        <c:when test="${module.running == true}">
                                            <a href="<c:url value="/module?moduleIndex=${loop.index}&activate=false"/>">deactivate</a> 
                                        </c:when>

                                        <c:when test="${module.running == false}">
                                            <a href="<c:url value="/module?moduleIndex=${loop.index}&activate=true"/>">activate</a> 
                                        </c:when>
                                    </c:choose>
                                </td> 
                                <td>${module.getName()}</td>
                            </tr>
                        </c:forEach>
                    </tbody> 
                </table>
            </div>
        </div>

    </jsp:attribute>
</t:general_form>

