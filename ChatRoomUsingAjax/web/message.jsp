<%-- 
    Document   : message
    Created on : Feb 23, 2018, 9:44:58 PM
    Author     : IbrahimDesouky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chat Room</title>
        <meta charset="UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <script src="js/messageHndling.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    </head>
    <body >
        <form action="signUphandling" method="post">
        
        <input type="submit" value="logout">
        <input type="hidden" name="page" value="button" >
        </form>
        <div >${sessionScope['name']}</div>
        <input type="hidden" id="name" value="${sessionScope['name']}">
        Message<input type="text" id="msg">
        <input type="button" id="button" value="send">
        <div id="div"></div>
        <div id="div2"></div>
<!--        <table id="users">
            <tr><th>users</th></tr>
            
        </table>
            -->
        
        
    </body>
</html>
