<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:general_form title="home">
    <jsp:attribute name="content">

        <div class="row">
            <jsp:include page="/WEB-INF/jsp/menu.jsp" flush="true" />



            <div class="panel-body">

                <p>Setting for parser</p>


                    
                    
                    <form  method="POST" action="" > 
                           <p>Parser status=${parserStatus}</p>
                           <input type="hidden" name="parserAction" value="${parserAction}">
                           <input type="submit" name="submit" class="login login-submit  btn btn-lg btn-success" value="${parserAction}">
                    </form>

            </div>
        </div>

                    

                    
                    
    </jsp:attribute>
</t:general_form>

