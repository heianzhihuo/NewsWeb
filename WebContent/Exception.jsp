<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新闻系统异常信息</title>
    </head>
    <body>
        <h3>Web应用出错啦，错误信息如下：</h3><br>
        <b>异常信息：</b>${exception.message}<br>
        <b>异常堆栈信息：</b><br>${exceptionStack}
    </body>
</html>
