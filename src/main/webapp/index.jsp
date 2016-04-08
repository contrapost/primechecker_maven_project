<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<meta charset="utf-8"/>
<title>Prime checker</title>
<style>
    #top {
        text-align: center;
    }
</style>
<body id="top">
<h2>Prime checker</h2>
<br/>
<br/>
<div>
    <form action="CheckPrime" method="GET">
        <input type="text" size="10" name="number"/>
        <input type="submit" value="Check"/> <input type="reset" value="Reset"/>
    </form>
</div>
<div>
    <% if (request.getAttribute("answer") != null) { %>
    <p> <%=(String) request.getAttribute("answer") %> </p>
    <% } %>
</div>
</body>
</html>
