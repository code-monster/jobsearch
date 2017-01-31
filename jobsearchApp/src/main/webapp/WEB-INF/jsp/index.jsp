<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:general_form title="home">
    <jsp:attribute name="content">

        <c:forEach var="vacancy"  items="${vacancyList}" >

            <div class="row">
                <div class="large-6 columns">
                    <h5><a href="#">${vacancy.vacancyName}</a></h5>
                    <p>${vacancy.description}</p>
                    <span><i class="fi-marker"> Location: ${vacancy.location}</i></span>
                    <p><span><i class="fi-database"> Provider: ${vacancy.provider}</i></span></p>
                </div>

                <div>
                    <span><i class="fi-dollar"> Salary: ${vacancy.salary}</i></span>
                    <br>
                    <span><i class="fi-torso"> Company: ${vacancy.companyName}</i></span>
                    <br>
                    <span><i class="fi-clock"> Posted time: ${vacancy.creationDate}</i></span>
                    <br>
                    <h5><a href="${vacancy.originalLink}">${vacancy.originalLink}</a></h5>

                </div>
            </div> 
            <hr/>
        </c:forEach>
    </jsp:attribute>
</t:general_form>

 