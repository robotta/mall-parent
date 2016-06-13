<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<#import "/spring.ftl" as spring />
<html>
<head>
    <title>用户列表</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<p><a href="/language.htm?language=en_us">英文</a></p>
<p><a href="/language.htm?language=en_th">泰文</a></p>
<p><a href="/language.htm?language=en_id">印尼文</a></p>
<p><a href="/language.htm?language=en_my">马来文</a></p>
<p><a href="/language.htm?language=zh_cn">中文</a></p>
<@spring.message code="hello" />
<hr/>
<a href="#">用户列表</a><br/>
<table border="1">
    <tr>
        <td><@spring.message code="name"/></td>
        <td><@spring.message code="age"/></td>
        <td><@spring.message code="code"/></td>
        <td><@spring.message code="operate"/></td>
    </tr>
<#list users as user>
    <tr>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.id}</td>
        <td><a href="http://localhost/htmlpage/DelUser.do?id=${user.id}">delete</a></td>
    </tr>
</#list>

</table>
<hr/>
</body>
</html>