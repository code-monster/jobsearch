<%--
  Created by IntelliJ IDEA.
  User: Sergey Matevitsky
  Date: 20.12.16
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
    <link href='http://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet'
          type='text/css'>
    <title>Title</title>
</head>
<body>
<header>
    <div class="top-bar">

        <div class="top-bar-left">

            <ul class="menu">

                <li><a href="#">One</a></li>
                <li><a href="#">Two</a></li>
                <li><a href="#">Three</a></li>
                <li><a href="#">Four</a></li>
            </ul>

        </div>
        <div class="top-bar-right">
            <ul class="menu">
                <li><input type="search" placeholder="Search"></li>
                <li>
                    <button type="button" class="button">Search</button>
                </li>
            </ul>
        </div>
    </div>
</header>
<article>

    <div class="row">

        <div class="large-6 columns">
            <h5><a href="#">Vacancy Name</a></h5>
            <p>Job Description bla bla bla</p>
            <span><i class="fi-marker">Location &nbsp;&nbsp;</i></span>
        </div>

        <p>
            <span><i class="fi-dollar"> Salary &nbsp;&nbsp;</i></span>
            <br>
            <span><i class="fi-torso"> Company name &nbsp;&nbsp;</i></span>
            <br>
            <span><i class="fi-clock"> Posted time &nbsp;&nbsp;</i></span>
            <br>
        <h5><a href="#">rabota.ua</a></h5>

        </p>


    </div>

    <%-- Cell Template from the internet--%>

    <%-- <hr>

     <div class="row">
         <div class="large-6 columns">
             <p><img src="http://placehold.it/600x370&text=Look at me!" alt="image for article"
                     alt="article preview image"></p>
         </div>
         <div class="large-6 columns">
             <h5><a href="#">NASA's SLS Rocket Sheds Saturn V Color Scheme in Design Review</a></h5>
             <p>
                 <span><i class="fi-torso"> By Thadeus &nbsp;&nbsp;</i></span>
                 <span><i class="fi-calendar"> 11/23/16 &nbsp;&nbsp;</i></span>
                 <span><i class="fi-comments"> 6 comments</i></span>
             </p>
             <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae impedit beatae, ipsum delectus
                 aperiam nesciunt magni facilis ullam.</p>
         </div>
     </div>

     <hr>
 --%>

    <hr>


    <ul class="pagination" role="navigation" aria-label="Pagination">
        <li class="disabled">Previous <span class="show-for-sr">page</span></li>
        <li class="current"><span class="show-for-sr">You're on page</span> 1</li>
        <li><a href="#" aria-label="Page 2">2</a></li>
        <li><a href="#" aria-label="Page 3">3</a></li>
        <li><a href="#" aria-label="Page 4">4</a></li>
        <li><a href="#" aria-label="Next page">Next <span class="show-for-sr">page</span></a></li>
    </ul>

</article>

</div>


</body>

</html>
