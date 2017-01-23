<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:general_form title="home">
    <jsp:attribute name="content">

        <div class="row">
            <jsp:include page="/WEB-INF/jsp/menu.jsp" flush="true" />

            <div class="panel-body">

                <p>Setting for parser</p>
                  
                    <form:form  method="POST" commandName="parserSetting" action="">
                           <p>Parser status=${parserSetting.status}</p>
                            <form:hidden path="action" />
                           <input type="submit" name="submit" class="login login-submit  btn btn-lg btn-success" value="${parserSetting.action}">
                    </form:form>     
          
            </div>
        </div>

            
    </jsp:attribute>
</t:general_form>

