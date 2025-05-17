<%@ page session="true" %>
<%
    if(session.getAttribute("username") == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Course Feedback</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Provide Feedback</h2>
    <form action="feedback" method="post">
        <label>Teaching Quality: <input type="number" name="teaching" min="1" max="10" required></label><br>
        <label>Course Content: <input type="number" name="content" min="1" max="10" required></label><br>
        <label>Lab Facilities: <input type="number" name="labs" min="1" max="10" required></label><br>
        <label>Time Management: <input type="number" name="time" min="1" max="10" required></label><br>
        <label>Doubt Resolution: <input type="number" name="doubt" min="1" max="10" required></label><br>
        <label>Comments: <br><textarea name="comments" rows="4" cols="50"></textarea></label><br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
