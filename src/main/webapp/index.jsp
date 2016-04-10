<html>
<head>
    <title>Prime checker</title>
    <style>
        #center {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="center">
    <h2>Prime checker</h2>
    <br/>
    <br/>
    <div>
        <form action="CheckPrime" method="GET">
            <input type="text" size="10" name="number" required/>
            <input type="submit" value="Check"/> <input type="reset" value="Reset"/>
        </form>
    </div>
    <div>
        <% if (request.getAttribute("answer") != null) { %>
        <p> <%=(String) request.getAttribute("answer") %> </p>
        <% } %>
    </div>
</div>
</body>
</html>
