<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h2>Hello World!</h2>
<div id="fileupdate">
    <form action="LoadServlet" method="post" enctype="multipart/form-data">
        文件上传：<input id="myFile" name="myFile" type="file"/><br/>
        <input type="submit" value="上传"/>
    </form>
    <hr>
    <form action="/file/down" method="get">
        <input type="submit" value="下载">
    </form>
</div>
</body>
</html>
