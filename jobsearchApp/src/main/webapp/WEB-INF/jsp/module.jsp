<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:general_form title="home">
    <jsp:attribute name="content">

        <div class="row">
            <div class="large-12 columns">

                <h3>Modules:</h3>
                
                
                <form:form  method="POST" commandName="moduleSetting" action="">

                    <table border="1" class="modules">
                        <tr><th>name</th><th>enable</th><tr/>
                           
                        <tr>
                                <td>${moduleSetting.name}</td>
                                <td><form:checkbox path="enable" /></td>
                        <tr/> 

                    </table>
                    <form:hidden path="moduleIndex" />   
                    <input type="submit" name="submit" class="login login-submit  btn btn-lg btn-success" value="Save">
                </form:form> 
            </div>
        </div>

    </jsp:attribute>
</t:general_form>

