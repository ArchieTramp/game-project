<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Создайте игрового персонажа.
    </div>
    <form method="post" action="/creatplayer">
        <br>
        <label for="nick-name">NickName
            <input class="input-field" id="nick-name" name="nickName">
            <#if message??>
                <div class="alert alert-danger" role="alert">${message}</div>
            </#if>
            <#if messageNickName??>
                <div class="alert alert-danger" role="alert">${messageNickName}</div>
            </#if>
        </label>
        <br>
        <input type="submit" value="Создать">
        <br>
    </form>
</div>

<a href="/">Вернуться на главный экран</a>

</body>
</html>